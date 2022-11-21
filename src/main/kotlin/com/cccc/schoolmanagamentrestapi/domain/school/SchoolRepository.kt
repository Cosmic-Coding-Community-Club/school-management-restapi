package com.cccc.schoolmanagamentrestapi.domain.school

import reactor.core.publisher.Mono

interface SchoolRepository {
    
    fun create(name: String): Mono<School>
    
    fun read(identifier : String): Mono<School>
    
}