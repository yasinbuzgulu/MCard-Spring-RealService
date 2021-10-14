package com.example.MCardSpring.Exception;

public class UserBadRequestException extends RuntimeException{
    public UserBadRequestException (Long id){
        super("Non valid user with id :" + id + "Because includes invalid attribute" );
    }
}
