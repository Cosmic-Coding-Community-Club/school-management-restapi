package com.cccc.schoolmanagamentrestapi.infrastructure.controller.dto

data class CreateClassroomDto @JvmOverloads constructor(
    val name: String,
    val code: String,
    val capacity: Int
)
