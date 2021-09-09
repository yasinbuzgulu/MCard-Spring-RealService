package com.example.MCardSpring.Service;

import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Repository.ApplicantRepository;
import com.example.MCardSpring.Repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository;

    private final ApplicantRepository applicantRepository;

    public CardService(CardRepository cardRepository, ApplicantRepository applicantRepository) {
        this.cardRepository = cardRepository;
        this.applicantRepository = applicantRepository;
    }

    /**
     * Create a new role along with users
     * @return
     */
    public ResponseEntity<Object> createCard(Card card) {


        return null;
    }

        /**
         * Delete a specified role given the id
         */

    public ResponseEntity<Object> deleteCard(Long id) {

        if (cardRepository.findByCardIdentity(id).isPresent()) {
            cardRepository.deleteById(id);
            if (cardRepository.findByCardIdentity(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Kart silme işlemi başarısız");
            } else return ResponseEntity.ok().body("Kart başarı ile silindi");
        } else
        return ResponseEntity.unprocessableEntity().body("Kayıt bulunamadı");
    }
}
