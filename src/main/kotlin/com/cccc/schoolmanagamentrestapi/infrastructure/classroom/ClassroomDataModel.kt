package com.cccc.schoolmanagamentrestapi.infrastructure.classroom

data class ClassroomDataModel(
    val identifier: String,
    val name: String,
    val code : String,
    val capacity: Int,
    val schoolIdentifier: String
)
