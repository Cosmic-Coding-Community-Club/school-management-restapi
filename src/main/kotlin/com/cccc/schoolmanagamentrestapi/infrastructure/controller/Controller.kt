package com.cccc.schoolmanagamentrestapi.infrastructure.controller

import com.cccc.schoolmanagamentrestapi.application.createschool.CreateSchoolApplicationService
import com.cccc.schoolmanagamentrestapi.application.model.QuerySchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto.CreateSchoolDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/management")
class Controller(
    private val createSchoolApplicationService: CreateSchoolApplicationService,
    private val createSchoolDtoMapper: CreateSchoolDtoMapper
) {
    
    
    @RequestMapping(
        value = ["/school"],
        method = [POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createSchool(
        @RequestBody createSchoolDto: CreateSchoolDto
    ): Mono<ResponseEntity<QuerySchoolApplicationModel>> {
        return Mono.just(createSchoolDto)
            .filter(validate())
            .map(createSchoolDtoMapper::map)
            .flatMap(createSchoolApplicationService::createSchool)
            .map { ResponseEntity.ok(it) }
            .switchIfEmpty(Mono.error(InvalidBodyErrorException()))
    }
    
    private fun validate(): (createSchoolDto: CreateSchoolDto) -> Boolean = {
        it.schoolName.isNotBlank() && it.classrooms.isNotEmpty()
    }
}