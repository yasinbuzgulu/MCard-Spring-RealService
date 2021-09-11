package com.example.MCardSpring.MainModel;

import javax.persistence.*;
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
    @ManyToMany(targetEntity = Opportunity.class)
    private List<Opportunity> opportunity;

      public CityOpportunity(Long id, City city, List<Opportunity> opportunity) {
        this.id = id;
        this.city = city;
        this.opportunity = opportunity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Opportunity> getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(List<Opportunity> opportunity) {
        this.opportunity = opportunity;
    }

      @Override
    public String toString() {
        return "CityOpportunity{" +
                "id=" + id +
                ", city=" + city +
                ", opportunity=" + opportunity +
                '}';
    }
}
