package com.example.MCardSpring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Applicant ta exception durumu için handling
 */
@ControllerAdvice
class ApplicantNotFoundAdvice    {

    @ResponseBody
    @ExceptionHandler(ApplicantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String applicantNotFoundHandler (ApplicantNotFoundException applicantNotFoundException) {
        return applicantNotFoundException.getMessage();
    }
}
