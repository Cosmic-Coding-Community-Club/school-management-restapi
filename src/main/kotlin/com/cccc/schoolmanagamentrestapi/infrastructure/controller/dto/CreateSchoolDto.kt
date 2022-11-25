package com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto

data class CreateSchoolDto @JvmOverloads constructor(
    val schoolName: String = "",
    val classrooms: List<CreateClassroomDto> = emptyList()
)
