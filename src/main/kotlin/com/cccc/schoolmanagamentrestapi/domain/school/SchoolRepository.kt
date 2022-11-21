package com.cccc.schoolmanagamentrestapi.domain.school

import reactor.core.publisher.Mono

interface SchoolRepository {
    
    fun createSchool(name: String): Mono<School>
    fun readSchool(identifier : String): Mono<School>
    
}