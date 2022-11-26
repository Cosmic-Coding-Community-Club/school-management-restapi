package com.cccc.schoolmanagamentrestapi.infrastructure.controller

import com.cccc.schoolmanagamentrestapi.application.model.CreateClassroomApplicationModel
import com.cccc.schoolmanagamentrestapi.application.model.CreateSchoolApplicationModel
import com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto.CreateSchoolDto

class CreateSchoolDtoMapper {
    
    fun map(createSchoolDto: CreateSchoolDto) = with(createSchoolDto) {
        CreateSchoolApplicationModel(
            schoolName = schoolName,
            classrooms = classrooms
                .map {
                    CreateClassroomApplicationModel(
                        name = it.name,
                        code = it.code,
                        capacity = it.capacity
                    )
                }
        )
    }
}