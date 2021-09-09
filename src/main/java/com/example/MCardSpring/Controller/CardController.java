package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {
    private CardService cardService;

    private CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("cards/")
    public ResponseEntity<Object> createCard (@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @DeleteMapping("cards/{id}")
    public ResponseEntity<Object> deleteCard (@PathVariable Long id) {
        return cardService.deleteCard(id);
    }
}
