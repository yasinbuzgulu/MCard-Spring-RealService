package com.example.MCardSpring.MainModel;

import com.sun.istack.NotNull;

import javax.persistence.*;

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
    @NotNull
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
    private CityOpportunity cityOpportunity;

    /**
     * Kart kaydında seçilen olanakların kaç yıl için tanımlanacağı
     */
    private int cardOpportunityYear;

    public Card() {
    }

    public Card(Long id, int price, String expiryDate, Applicant applicant, CityOpportunity cityOpportunity,
                int cardOpportunityYear) {
        this.id = id;
        this.price = price;
        this.expiryDate = expiryDate;
        this.applicant = applicant;
        this.cityOpportunity = cityOpportunity;
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

    public CityOpportunity getCityOpportunity() {
        return cityOpportunity;
    }

    public void setCityOpportunity(CityOpportunity cityOpportunity) {
        this.cityOpportunity = cityOpportunity;
    }

    public int getCardOpportunityYear() {
        return cardOpportunityYear;
    }

    public void setCardOpportunityYear(int cardOpportunityYear) {
        this.cardOpportunityYear = cardOpportunityYear;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", price=" + price +
                ", expiryDate='" + expiryDate + '\'' +
                ", applicant=" + applicant +
                ", cityOpportunity=" + cityOpportunity +
                ", cardOpportunityYear=" + cardOpportunityYear +
                '}';
    }
}
