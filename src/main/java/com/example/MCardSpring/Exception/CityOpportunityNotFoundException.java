package com.example.MCardSpring.Exception;

public class CityOpportunityNotFoundException extends RuntimeException{
    public CityOpportunityNotFoundException(Long id) {
        super(id + "' sine sahip şehir-olanak kaydı bulunamamıştır!");
    }

}
