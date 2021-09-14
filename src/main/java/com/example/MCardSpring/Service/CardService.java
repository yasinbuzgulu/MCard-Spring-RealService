package com.example.MCardSpring.Service;

import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Repository.CardRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *  CRUD işlemlerini yapan servis sınıfım
 */
@Service
public class CardService {
    /**
     * Service içinde kullanılacak applicant repository için instance oluşturmadan constructor ile çağrılır
     */
    private final CardRepository cardRepository;
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     *  Yeni kart oluşturma metodu
     * @param card: yeni kart nesnesi
     * @return: repository ye kayıt döner
     */
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    /**
     *  id ye sahip kartı silen metot
     * @param id:  siinecek kart id si
     */
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    /**
     * Tüm kartları listeleyen metot
     * @return: tüm başvuranları repositoryden bulup döner
     */
    public List<Card> listTheCards() {
        return new ArrayList<>(cardRepository.findAll());
    }

    /**
     *  id ye sahip kartı bulur
     * @param id: çağırılan kartın id si
     * @return: girilen id li kartı döner
     */
    public Card getCardById(Long id) {
        return cardRepository.findById(id).get();
    }

    /**
     * Kartın bilgi güncellemesini yapan sınıf
     * @param newCard: güncellenmiş yeni kartın nesnesi
     * @param id:  düzenlemenin yapıldığı kartın id si
     */
    public void updateCard(Card newCard, Long id) {
        Card card = cardRepository.findById(id).get();
        System.out.println(card.toString());
        card.setId(newCard.getId());
        card.setApplicant(newCard.getApplicant());
        card.setCardOpportunityYear(newCard.getCardOpportunityYear());
        card.setCityOpportunity(newCard.getCityOpportunity());
        card.setPrice(newCard.getPrice());
        card.setExpiryDate(newCard.getExpiryDate());
        cardRepository.save(card);
    }

}
