package com.cccc.schoolmanagamentrestapi.infrastructure.classroom

import com.cccc.schoolmanagamentrestapi.domain.classroom.Classroom
import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassroomRepository
import reactor.core.publisher.Mono

class MemoryClassroomRepository : ClassroomRepository {
    
    private val classRooms: MutableMap<String, Classroom> = mutableMapOf()
    
    override fun create(classroom: Classroom): Mono<Classroom> =
        Mono.just(classroom)
            .doOnNext { classRooms[it.identifier] = it }
    
    override fun read(identifier: String): Mono<Classroom> =
        Mono.fromCallable {
            classRooms[identifier] ?: throw RuntimeException("Classroom not found")
        }
}