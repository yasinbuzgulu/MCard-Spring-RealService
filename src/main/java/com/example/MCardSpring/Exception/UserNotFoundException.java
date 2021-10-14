package com.example.MCardSpring.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("No user with id :" + id );
    }

}
