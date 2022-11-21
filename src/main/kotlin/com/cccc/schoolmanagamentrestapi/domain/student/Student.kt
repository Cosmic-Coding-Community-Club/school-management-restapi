package com.cccc.schoolmanagamentrestapi.domain.student

data class Student(
    val identifier: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val assignedClassroomIdentifier : String
)
