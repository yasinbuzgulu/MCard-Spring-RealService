package com.example.MCardSpring.Exception;

public class ApplicantBadRequestException extends RuntimeException {
    public ApplicantBadRequestException (Long id){
        super("Non valid applicant with id :" + id + "Because includes invalid attribute" );
    }
}
