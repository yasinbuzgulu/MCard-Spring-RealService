package com.example.MCardSpring.MainModel;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * Kart nesnesinin özelliklerini belirten entity
 */
@Entity
public class Card {
    /**
     * Kart kaydının tutulduğu unique ID
     */
    @Id
    @GeneratedValue
    private Long id;

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
    @ManyToOne(fetch = FetchType.EAGER)
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

    public Card(Long id, int price, String expiryDate, Applicant applicant, CityOpportunity city,
                List<CityOpportunity> cardOpportunities, String cardOpportunityYear) {
        this.id = id;
        this.price = price;
        this.expiryDate = expiryDate;
        this.applicant = applicant;
        this.city = city;
        this.cardOpportunities = cardOpportunities;
        this.cardOpportunityYear = cardOpportunityYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public CityOpportunity getCity() {
        return city;
    }

    public void setCity(CityOpportunity city) {
        this.city = city;
    }

    public List<CityOpportunity> getCardOpportunities() {
        return cardOpportunities;
    }

    public void setCardOpportunities(List<CityOpportunity> cardOpportunities) {
        this.cardOpportunities = cardOpportunities;
    }

    public String getCardOpportunityYear() {
        return cardOpportunityYear;
    }

    public void setCardOpportunityYear(String cardOpportunityYear) {
        this.cardOpportunityYear = cardOpportunityYear;
    }
}
