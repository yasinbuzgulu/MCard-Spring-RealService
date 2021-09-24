package com.example.MCardSpring.Exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(Long id) {
        super( "No city with id: "+ id );
    }
}
