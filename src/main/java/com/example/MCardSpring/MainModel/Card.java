package com.example.MCardSpring.MainModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class Card {
    /**
     * Kart kaydının tutulduğu unique ID
     */
    @Id
    @GeneratedValue
    private Long cardIdentity;

    /**
     * Kart kaydında kart fiyatı
     */
    private int price;

    /**
     * Kart kaydında kart son kullanma tarihi
     */
    private String expiryDate;

    /**
     * Kart kaydında karta başvuranın
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Applicant applicant;

    /**
     * Kart kaydında kartın tanımlandığı şehir
     */
    @ManyToOne(targetEntity = CityOpportunity.class)
    private CityOpportunity city;

    /**
     * Kart kaydında kartın tanımlandığı şehirlerden seçilen olanaklar
     */
    @ManyToMany(targetEntity = CityOpportunity.class)
    private List<CityOpportunity> cardOpportunities;

    /**
     * Kart kaydında seçilen olanakların kaç yıl için tanımlanacağı
     */
    private String cardOpportunityYear;

    public Card() {
    }

}
