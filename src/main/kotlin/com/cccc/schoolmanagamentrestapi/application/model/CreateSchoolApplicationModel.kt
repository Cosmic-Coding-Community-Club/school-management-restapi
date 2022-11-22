package com.cccc.schoolmanagamentrestapi.application.model


data class CreateSchoolApplicationModel(
    val schoolName: String,
    val createClassroomApplicationModel: List<CreateClassroomApplicationModel>
)
