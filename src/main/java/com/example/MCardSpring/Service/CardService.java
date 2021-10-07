package com.example.MCardSpring.Service;

import com.example.MCardSpring.Exception.ApplicantBadRequestException;
import com.example.MCardSpring.Exception.CardBadRequestException;
import com.example.MCardSpring.Exception.CardNotFoundException;
import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.Repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CRUD işlemlerini yapan servis sınıfım
 */
@Service
@Transactional
public class CardService {
    /**
     * Service içinde kullanılacak applicant repository için instance oluşturmadan constructor ile çağrılır
     */
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    /**
     * Yeni kart oluşturma metodu
     *
     * @param card: yeni kart nesnesi
     * @return: repository ye kayıt döner
     */
    public Card createCard(Card card) {
        validateCard(card);
        return cardRepository.save(card);
    }

    /**
     * id ye sahip kartı silen metot
     *
     * @param id: siinecek kart id si
     */
    public void deleteCard(Long id) {
        try {
            cardRepository.deleteById(id);
        } catch (Exception e) {
            throw new CardNotFoundException(id);
        }
    }

    /**
     * Tüm kartları listeleyen metot
     *
     * @return: tüm başvuranları repositoryden bulup döner
     */
    public List<Card> listCards() {
        return new ArrayList<>(cardRepository.findAll());
    }

    /**
     * id ye sahip kartı bulur
     *
     * @param id: çağırılan kartın id si
     * @return: girilen id li kartı döner
     */
    public Card getCardById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new CardNotFoundException(id));
    }

    /**
     * Kartın bilgi güncellemesini yapan sınıf
     *
     * @param newCard: güncellenmiş yeni kartın nesnesi
     * @param id:      düzenlemenin yapıldığı kartın id si
     */
    public void updateCard(Card newCard, Long id) {
        Card card = cardRepository.findById(id).get();
        validateCard(newCard);

        card.setApplicant(newCard.getApplicant());
        card.setCardOpportunityYear(newCard.getCardOpportunityYear());
        card.setCityOpportunity(newCard.getCityOpportunity());
        card.setPrice(newCard.getPrice());
        card.setExpiryDate(newCard.getExpiryDate());
        cardRepository.save(card);
    }

    void validateCard(Card card) {
        if (card.getApplicant() == null || card.getCityOpportunity() == null || card.getExpiryDate() == null ||
                card.getCardOpportunityYear() == null || card.getPrice() == null
                || card.getPrice() < 0 || card.getCardOpportunityYear() < 0 || card.getCardOpportunityYear() > 5) {
            throw new CardBadRequestException(card.getId());
        }

        String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\5(?:0?[1-9]|1\\d|2[0-8])$|^(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(\\/|-|\\.)0?2\\6(29)$|^(?:(?:1[6-9]|[2-9]\\d)?\\d{2})(?:(?:(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\8(?:29|30))|(?:(\\/|-|\\.)(?:0?[13578]|1[02])\\9(?:31)))$\n";
        Pattern patternDate = Pattern.compile(regexDate);
        Matcher matcherDate = patternDate.matcher(card.getExpiryDate());
        if (!matcherDate.matches() ) {
            throw new ApplicantBadRequestException(card.getId());
        }

    }

}
