package com.cccc.schoolmanagamentrestapi.domain.classroom

import reactor.core.publisher.Mono
import java.util.UUID

class ClassroomService(
    private val classroomRepository: ClassroomRepository
) {
    
    fun create(name: String, code: String, capacity: Int, schoolIdentifier: String): Mono<Classroom> {
        return Mono.just(
            Classroom(
                identifier = UUID.randomUUID().toString(),
                name = name,
                code = code,
                capacity = capacity,
                schoolIdentifier = schoolIdentifier
            )
        )
            .flatMap { classroomRepository.create(it) }
    }
}