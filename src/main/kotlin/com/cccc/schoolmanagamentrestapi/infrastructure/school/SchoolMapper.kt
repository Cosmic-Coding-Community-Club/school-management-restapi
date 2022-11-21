package com.cccc.schoolmanagamentrestapi.infrastructure.school

import com.cccc.schoolmanagamentrestapi.domain.school.School

class SchoolMapper {
    
    fun map(school: School) = with(school) {
        SchoolDataModel(
            identifier = identifier,
            name = name,
        )
    }
    
    fun map(schoolDataModel: SchoolDataModel) = with(schoolDataModel) {
        School(
            identifier = identifier,
            name = name,
        )
    }
    
}