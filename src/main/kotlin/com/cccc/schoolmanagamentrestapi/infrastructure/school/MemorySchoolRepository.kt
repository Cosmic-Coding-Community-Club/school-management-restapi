package com.cccc.schoolmanagamentrestapi.infrastructure.school

import com.cccc.schoolmanagamentrestapi.domain.school.School
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolRepository
import reactor.core.publisher.Mono
import java.util.UUID

class MemorySchoolRepository(
    private val schoolMapper: SchoolMapper
) : SchoolRepository {
    
    private val schools: MutableList<SchoolDataModel> = mutableListOf()
    
    override fun createSchool(name: String): Mono<School> =
        Mono.just(SchoolDataModel(UUID.randomUUID().toString(), name))
            .doOnNext { schools.add(it) }
            .map(schoolMapper::map)
    
    override fun readSchool(identifier: String): Mono<School> =
        Mono.fromCallable {
            schools.firstOrNull { identifier == it.identifier }
                ?: throw RuntimeException()
        }
            .map(schoolMapper::map)
    
    
    
}