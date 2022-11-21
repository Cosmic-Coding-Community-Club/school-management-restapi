package com.cccc.schoolmanagamentrestapi.application

import com.cccc.schoolmanagamentrestapi.domain.school.School
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolService
import reactor.core.publisher.Mono

class CreateSchoolService(
    private val schoolService: SchoolService
) {
    
    fun createSchool(): Mono<School> {
        schoolService.createSchool()
    }
}