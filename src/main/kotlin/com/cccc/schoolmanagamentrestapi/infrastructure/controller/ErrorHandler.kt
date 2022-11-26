package com.cccc.schoolmanagamentrestapi.infrastructure.controller

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice(basePackages = ["com.cccc.schoolmanagamentrestapi.infrastructure.controller"])
class ErrorHandler {
    
    
    @ExceptionHandler(InvalidBodyErrorException::class)
    fun handleInvalidBodyErrorException() = ResponseEntity("Error on body request", UNPROCESSABLE_ENTITY)
}