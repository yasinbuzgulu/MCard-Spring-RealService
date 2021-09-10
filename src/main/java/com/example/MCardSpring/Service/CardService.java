package com.example.MCardSpring.Service;

import com.example.MCardSpring.Controller.CardController;
import com.example.MCardSpring.Exception.ApplicantNotFoundException;
import com.example.MCardSpring.Exception.CardNotFoundException;
import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Repository.CardRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public ResponseEntity<Object> createCard(Card card) {
        if (cardRepository.findById(card.getId()).isPresent()) {
            System.out.println("Bu Kart zaten mevcut");
            return ResponseEntity.badRequest().body("Mevcut kart!!, Kart başvurusu yapılamadı");
        } else {
            cardRepository.save(card);
        }
        return null;
    }

    public ResponseEntity<Object> deleteCard(Long id) {

        if (cardRepository.findById(id).isPresent()) {
            cardRepository.deleteById(id);
            if (cardRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Kart silme işlemi başarısız");
            } else return ResponseEntity.ok().body("Kart başarı ile silindi");
        } else
            return ResponseEntity.unprocessableEntity().body("Kayıt bulunamadı");
    }

    public List<EntityModel<Card>> listTheCards() {
        return cardRepository.findAll().stream()
                .map(card -> EntityModel.of(card,
                        linkTo(methodOn(CardController.class).getCardById(card.getId())).withSelfRel(),
                        linkTo(methodOn(CardController.class).listTheCards()).withRel("cards")))
                .collect(Collectors.toList());
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }

    @Transactional
    public Card updateCard(Card newCard, Long id) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setId(newCard.getId());
                    card.setApplicant(newCard.getApplicant());
                    card.setCardOpportunities(newCard.getCardOpportunities());
                    card.setCardOpportunityYear(newCard.getCardOpportunityYear());
                    card.setCity(newCard.getCity());
                    card.setPrice(newCard.getPrice());
                    card.setExpiryDate(newCard.getExpiryDate());
                    return cardRepository.save(card);
                })
                .orElseGet(() -> {
                    newCard.setId(id);
                    return cardRepository.save(newCard);
                });
    }
}
