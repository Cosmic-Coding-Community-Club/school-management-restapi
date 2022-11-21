package com.cccc.schoolmanagamentrestapi.infrastructure.school

import com.cccc.schoolmanagamentrestapi.domain.school.School
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolRepository
import reactor.core.publisher.Mono
import java.util.UUID

class MemorySchoolRepository(
    private val schoolMapper: SchoolMapper
) : SchoolRepository {
    
    private val schools: MutableMap<String, SchoolDataModel> = mutableMapOf()
    
    override fun create(name: String): Mono<School> =
        Mono.just(SchoolDataModel(UUID.randomUUID().toString(), name))
            .doOnNext { schools[it.identifier] = it }
            .map(schoolMapper::map)
    
    override fun read(identifier: String): Mono<School> =
        Mono.fromCallable {
            schools[identifier] ?: throw RuntimeException()
        }
            .map(schoolMapper::map)
    
    
}