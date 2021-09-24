package com.example.MCardSpring.Exception;

public class OpportunityNotFoundException extends RuntimeException{
    public OpportunityNotFoundException(Long id) {
        super( "No opportunity with id: "+ id );
    }
}
