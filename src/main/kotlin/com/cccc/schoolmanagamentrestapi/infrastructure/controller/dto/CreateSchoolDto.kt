package com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto

data class CreateSchoolDto(
    val schoolName : String,
    val createClassRoomDto : List<CreateClassroomDto>
)
