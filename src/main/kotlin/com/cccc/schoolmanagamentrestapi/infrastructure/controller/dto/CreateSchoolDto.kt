package com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto

data class CreateSchoolDto(
    val schoolName : String = "",
    val classrooms : List<CreateClassroomDto> = emptyList()
)
