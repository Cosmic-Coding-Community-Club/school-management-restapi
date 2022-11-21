package com.cccc.schoolmanagamentrestapi.infrastructure.classroom

import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassRoom
import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassRoomRepository
import reactor.core.publisher.Mono
import java.util.UUID

class MemoryClassRoomRepository : ClassRoomRepository {
    
    private val classRooms: MutableMap<String, ClassRoom> = mutableMapOf()
    
    override fun create(name: String, code: String, capacity: Int, schoolIdentifier: String): Mono<ClassRoom> =
        Mono.just(ClassRoom(UUID.randomUUID().toString(), name, code, capacity, schoolIdentifier))
            .doOnNext { classRooms[it.identifier] = it }
    
    override fun read(identifier: String): Mono<ClassRoom> =
        Mono.fromCallable {
            classRooms[identifier] ?: throw RuntimeException("Classroom not found")
        }
}