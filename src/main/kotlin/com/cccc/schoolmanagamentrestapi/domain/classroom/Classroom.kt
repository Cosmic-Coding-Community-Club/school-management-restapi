package com.cccc.schoolmanagamentrestapi.domain.classroom

data class Classroom(
    val identifier: String,
    val name: String,
    val code : String,
    val capacity: Int,
    val schoolIdentifier: String
)
