package com.cccc.schoolmanagamentrestapi.infrastructure.student

data class StudentDataModel(
    val identifier: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val assignedClassroom: String
)
