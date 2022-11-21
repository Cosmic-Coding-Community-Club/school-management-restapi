package com.cccc.schoolmanagamentrestapi.domain.student

import reactor.core.publisher.Mono

interface StudentRepository {
    
    fun create(firstName: String, lastName: String, phone: String, assignedClassroom: String): Mono<Student>
    
    fun read(identifier: String): Mono<Student>
}