package com.cccc.schoolmanagamentrestapi.infrastructure.bootstrap

import com.cccc.schoolmanagamentrestapi.application.createschool.CreateSchoolApplicationService
import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassroomRepository
import com.cccc.schoolmanagamentrestapi.domain.classroom.ClassroomService
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolRepository
import com.cccc.schoolmanagamentrestapi.domain.school.SchoolService
import com.cccc.schoolmanagamentrestapi.infrastructure.classroom.MemoryClassroomRepository
import com.cccc.schoolmanagamentrestapi.infrastructure.school.MemorySchoolRepository
import com.cccc.schoolmanagamentrestapi.infrastructure.school.SchoolMapper
import com.cccc.schoolmanagamentrestapi.infrastructure.student.MemoryStudentRepository
import com.cccc.schoolmanagamentrestapi.infrastructure.student.StudentMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Configuration {
    
    @Bean
    fun createSchoolApplicationService(
        schoolService: SchoolService,
        classroomService: ClassroomService
    ) = CreateSchoolApplicationService(schoolService, classroomService)
    
    @Bean
    fun schoolService(schoolRepository: SchoolRepository) = SchoolService(schoolRepository)
    
    @Bean
    fun schoolMapper() = SchoolMapper()
    
    @Bean
    fun schoolRepository(schoolMapper: SchoolMapper) = MemorySchoolRepository(schoolMapper)
    
    @Bean
    fun studentMapper() = StudentMapper()
    
    @Bean
    fun studentRepository(studentMapper: StudentMapper) = MemoryStudentRepository(studentMapper)
    
    @Bean
    fun classroomService(classroomRepository: ClassroomRepository) = ClassroomService(classroomRepository)
    
    @Bean
    fun classroomRepository() = MemoryClassroomRepository()
    
    
}