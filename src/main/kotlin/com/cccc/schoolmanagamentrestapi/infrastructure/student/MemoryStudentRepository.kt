package com.cccc.schoolmanagamentrestapi.infrastructure.student

import com.cccc.schoolmanagamentrestapi.domain.student.Student
import com.cccc.schoolmanagamentrestapi.domain.student.StudentRepository
import reactor.core.publisher.Mono
import java.util.UUID

class MemoryStudentRepository(
    private val studentMapper: StudentMapper
) : StudentRepository {
    
    private val schools: MutableList<StudentDataModel> = mutableListOf()
    
    override fun create(
        firstName: String,
        lastName: String,
        phone: String,
        assignedClassroom: String
    ): Mono<Student> =
        Mono.just(StudentDataModel(UUID.randomUUID().toString(), firstName, lastName, phone, assignedClassroom))
            .doOnNext { schools.add(it) }
            .map(studentMapper::map)
    
    override fun read(identifier: String): Mono<Student> =
        Mono
            .fromCallable {
                schools.firstOrNull { identifier == it.identifier }
                    ?: throw RuntimeException()
            }
            .map(studentMapper::map)
    
    
}