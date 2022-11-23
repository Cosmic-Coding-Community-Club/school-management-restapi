package com.cccc.schoolmanagamentrestapi.application.model


data class CreateSchoolApplicationModel(
    val schoolName: String,
    val classrooms: List<CreateClassroomApplicationModel>
)
