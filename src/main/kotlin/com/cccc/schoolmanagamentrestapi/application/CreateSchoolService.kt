package com.cccc.schoolmanagamentrestapi.application

import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassRoomRepository
import com.cccc.schoolmanagamentrestapi.domain.school.School
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolService
import reactor.core.publisher.Mono

class CreateSchoolService(
    private val schoolService: SchoolService,
    private val classRoomRepository: ClassRoomRepository
) {
    
    fun createSchool(name: String): Mono<School> =
        schoolService.createSchool(name)
    
}