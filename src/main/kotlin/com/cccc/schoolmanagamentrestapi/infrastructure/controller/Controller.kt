package com.cccc.schoolmanagamentrestapi.infrastructure.controller

import com.cccc.schoolmanagamentrestapi.application.createschool.CreateSchoolApplicationService
import com.cccc.schoolmanagamentrestapi.application.model.CreateClassroomApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.CreateSchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.QuerySchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto.CreateSchoolDto
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/management")
class Controller(
    private val createSchoolApplicationService: CreateSchoolApplicationService
) {
    
    
    @RequestMapping(method = [POST], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createSchool(@RequestBody createSchoolDto: CreateSchoolDto): Mono<QuerySchoolApplicationModel> {
        return Mono.just(createSchoolDto)
            .filter(validate())
            .map { dto ->
                CreateSchoolApplicationModel(
                    schoolName = dto.schoolName,
                    classrooms = dto
                        .classrooms
                        .map {
                            CreateClassroomApplicationModel(
                                name = it.name,
                                code = it.code,
                                capacity = it.capacity
                            )
                        }
                )
            }
            .flatMap(createSchoolApplicationService::createSchool)
            .switchIfEmpty(Mono.error(RuntimeException("Not body valid")))
    }
    
    
    private fun validate(): (createSchoolDto: CreateSchoolDto) -> Boolean = {
        it.schoolName.isNotBlank() && it.classrooms.isNotEmpty()
    }
}