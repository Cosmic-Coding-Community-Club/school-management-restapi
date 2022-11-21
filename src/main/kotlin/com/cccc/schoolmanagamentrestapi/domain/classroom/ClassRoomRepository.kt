package com.cccc.schoolmanagamentrestapi.domain.classroom

import reactor.core.publisher.Mono

interface ClassRoomRepository {
    
    fun create(name: String, code: String, capacity: Int, schoolIdentifier: String): Mono<ClassRoom>
    
    fun read(identifier: String): Mono<ClassRoom>
}