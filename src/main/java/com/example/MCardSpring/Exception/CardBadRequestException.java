package com.example.MCardSpring.Exception;

public class CardBadRequestException extends RuntimeException{
    public CardBadRequestException (Long id){
        super("Non valid card with id :" + id + "Because includes invalid attribute" );
    }
}
