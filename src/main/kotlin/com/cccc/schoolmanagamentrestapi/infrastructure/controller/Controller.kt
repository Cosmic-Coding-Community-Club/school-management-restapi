package com.cccc.schoolmanagamentrestapi.infrastructure.controller

import com.cccc.schoolmanagamentrestapi.application.createschool.CreateSchoolApplicationService
import com.cccc.schoolmanagamentrestapi.application.model.CreateClassroomApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.CreateSchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.QuerySchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto.CreateSchoolDto
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
    
    
    @RequestMapping(value = ["/school"], method = [POST])
    fun createSchool(@RequestBody createSchoolDto: CreateSchoolDto): Mono<QuerySchoolApplicationModel> {
        return Mono.just(createSchoolDto)
            .filter(validate())
            .map { dto ->
                CreateSchoolApplicationModel(
                    schoolName = dto.schoolName,
                    createClassroomApplicationModel = dto
                        .createClassRoomDto
                        .map {
                            CreateClassroomApplicationModel(
                                name = it.name,
                                code = it.code,
                                capacity = it.capacity,
                                schoolIdentifier = ""
                            )
                        }
                )
            }
            .flatMap(createSchoolApplicationService::createSchool)
            .switchIfEmpty(Mono.error(RuntimeException("Not body valid")))
    }
    
    
    private fun validate(): (createSchoolDto: CreateSchoolDto) -> Boolean = {
        it.schoolName.isNotBlank() && it.createClassRoomDto.isNotEmpty()
    }
}