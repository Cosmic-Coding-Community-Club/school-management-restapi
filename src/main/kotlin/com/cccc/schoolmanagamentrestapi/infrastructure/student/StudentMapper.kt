package com.cccc.schoolmanagamentrestapi.infrastructure.student

import com.cccc.schoolmanagamentrestapi.domain.student.Student

class StudentMapper {
    
    fun map(student: Student) = with(student) {
        StudentDataModel(
            identifier = identifier,
            firstName = firstName,
            lastName = lastName,
            phone = phone,
            assignedClassroom = assignedClassroom
        )
    }
    
    fun map(studentDataModel: StudentDataModel) = with(studentDataModel) {
        Student(
            identifier = identifier,
            firstName = firstName,
            lastName = lastName,
            phone = phone,
            assignedClassroom = assignedClassroom
        )
    }
    
}