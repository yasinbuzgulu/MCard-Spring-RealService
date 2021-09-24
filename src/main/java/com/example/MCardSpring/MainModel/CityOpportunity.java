package com.example.MCardSpring.MainModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Şehir-olanak nesnesinin özelliklerini belirten entity
 */
@Entity
public class CityOpportunity {

    /**
     * Şehir - Olanak kaydının tutulduğu unique ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Şehir - Olanak kaydında şehrin ismi
     */
    @ManyToOne( targetEntity = City.class)
    private City city;

    /**
     * Şehir - Olanak kaydında olanağın listesi (ismi - yıllık fiyatı - maxtanımlanma yılı)
     */
    @ManyToOne(targetEntity = Opportunity.class, fetch = FetchType.EAGER)
    private Opportunity opportunity;

    /**
     * Olanağın 1 yıl için fiyatı
     */
    private int perYearPrice;

    /**
     * Olanağın tanımlanabileceği max yıl
     */
    private int topLimitYearValue;

      public CityOpportunity(City city, Opportunity opportunity,int perYearPrice,int topLimitYearValue) {
        this.city = city;
        this.opportunity = opportunity;
        this.perYearPrice = perYearPrice;
        this.topLimitYearValue = topLimitYearValue;
    }

    public CityOpportunity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public int getPerYearPrice() {
        return perYearPrice;
    }

    public void setPerYearPrice(int perYearPrice) {
        this.perYearPrice = perYearPrice;
    }

    public int getTopLimitYearValue() {
        return topLimitYearValue;
    }

    public void setTopLimitYearValue(int topLimitYearValue) {
        this.topLimitYearValue = topLimitYearValue;
    }

    @Override
    public String toString() {
        return "CityOpportunity{" +
                "id=" + id +
                ", city=" + city +
                ", opportunity=" + opportunity +
                ", perYearPrice=" + perYearPrice +
                ", topLimitYearValue=" + topLimitYearValue +
                '}';
    }
}
