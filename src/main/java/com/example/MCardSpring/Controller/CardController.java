package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CardController {
    @Autowired
    private final CardService cardService;

    private CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/cards")
    public CollectionModel<EntityModel<Card>> listTheCards() {
        List<EntityModel<Card>> cards = cardService.listTheCards();
        return CollectionModel.of(cards, linkTo(methodOn(CardController.class)
                .listTheCards()).withSelfRel());
    }

    @GetMapping("/cards/{id}")
    public EntityModel<Card> getCardById(@PathVariable Long id) {
        Card card = cardService.getCardById(id);

        return EntityModel.of(card,
                linkTo(methodOn(CardController.class).getCardById(id)).withSelfRel(),
                linkTo(methodOn(CardController.class).listTheCards()).withRel("cards"));
    }

    @PostMapping("cards/")
    public ResponseEntity<Object> createCard (@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/cards/{id}")
    public EntityModel<Card> updateCard(@RequestBody Card newCard, @PathVariable Long id) {
        Card card = cardService.updateCard(newCard, id);
        return EntityModel.of(card,
                linkTo(methodOn(CardController.class).getCardById(id)).withSelfRel(),
                linkTo(methodOn(CardController.class).listTheCards()).withRel("cards"));
    }

    @DeleteMapping("cards/{id}")
    public ResponseEntity<Object> deleteCard (@PathVariable Long id) {
        return cardService.deleteCard(id);
    }
}
