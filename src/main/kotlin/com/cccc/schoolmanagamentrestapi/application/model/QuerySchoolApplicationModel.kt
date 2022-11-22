package com.cccc.schoolmanagamentrestapi.application.model

class QuerySchoolApplicationModel(
    val schoolIdentifier : String,
    val schoolName: String,
    val createClassroomApplicationModel: List<QueryClassroomApplicationModel>
) {
}