package com.cccc.schoolmanagamentrestapi.application.model

data class CreateClassroomApplicationModel(
    val name: String,
    val code: String,
    val capacity: Int,
    val schoolIdentifier: String
)
