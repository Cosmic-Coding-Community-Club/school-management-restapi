package com.cccc.schoolmanagamentrestapi.application.createschool

import com.cccc.schoolmanagamentrestapi.application.model.CreateSchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.QueryClassroomApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.QuerySchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.domain.classroom.Classroom
import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassroomService
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.util.function.Tuples

class CreateSchoolApplicationService(
    private val schoolService: SchoolService,
    private val classroomService: ClassroomService
) {
    
    fun createSchool(createSchoolApplicationModel: CreateSchoolApplicationModel): Mono<QuerySchoolApplicationModel> {
        return Mono.just(createSchoolApplicationModel)
            .flatMap { schoolService.createSchool(it.schoolName) }
            .flatMapMany { school ->
                Flux.fromIterable(createSchoolApplicationModel.classrooms)
                    .map { classroom -> Tuples.of(school, classroom) }
            }
            .flatMap { classroomService.create(it.t2.name, it.t2.code, it.t2.capacity, it.t1.identifier) }
            .collectList()
            .map { classroomList ->
                mapToQueryClassroom(
                    classroomList[0].schoolIdentifier,
                    createSchoolApplicationModel.schoolName,
                    classroomList
                )
            }
    }
    
    
    private fun mapToQueryClassroom(
        schoolIdentifier: String,
        schoolName: String,
        classroomList: List<Classroom>
    ) = QuerySchoolApplicationModel(
        schoolIdentifier = schoolIdentifier,
        schoolName = schoolName,
        createClassroomApplicationModel = classroomList
            .map { classroom ->
                QueryClassroomApplicationModel(
                    identifier = classroom.identifier,
                    name = classroom.name,
                    code = classroom.code,
                    capacity = classroom.capacity,
                    schoolIdentifier = classroom.schoolIdentifier
                )
            }
    )
}