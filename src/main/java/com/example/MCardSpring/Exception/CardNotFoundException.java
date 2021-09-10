package com.example.MCardSpring.Exception;

public class CardNotFoundException extends  RuntimeException{
    public CardNotFoundException(Long id) {
        super(id + "' sine sahip kart bulunamamıştır!");
    }

}
