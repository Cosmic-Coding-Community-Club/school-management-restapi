package com.cccc.schoolmanagamentrestapi.domain.school

class SchoolService(
    private val schoolRepository: SchoolRepository
) {
    
    fun createSchool(name: String) =
        schoolRepository.create(name)
    
}