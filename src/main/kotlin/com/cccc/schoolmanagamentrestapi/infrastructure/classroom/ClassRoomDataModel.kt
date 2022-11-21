package com.cccc.schoolmanagamentrestapi.infrastructure.classroom

data class ClassRoomDataModel(
    val identifier: String,
    val name: String,
    val code : String,
    val capacity: Int,
    val schoolIdentifier: String
)
