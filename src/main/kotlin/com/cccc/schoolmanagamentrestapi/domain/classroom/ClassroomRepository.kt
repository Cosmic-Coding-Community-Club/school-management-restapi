package com.cccc.schoolmanagamentrestapi.domain.classroom

import reactor.core.publisher.Mono

interface ClassroomRepository {
    
    fun create(classroom: Classroom): Mono<Classroom>
    
    fun read(identifier: String): Mono<Classroom>
}