package com.example.MCardSpring.MainModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class CityOpportunity {

    /**
     * Şehir - Olanak kaydının tutulduğu unique ID
     */
    @Id
    @GeneratedValue
    private int id;

    /**
     * Şehir - Olanak kaydında şehrin ismi
     */
    @ManyToOne( targetEntity = City.class)
    private City cityName;

    /**
     * Şehir - Olanak kaydında olanağın ismi
     */
    @ManyToMany(targetEntity = Opportunity.class)
    private List<Opportunity> opportunity;

    /**
     * Şehir - Olanak kaydında olanağın 1 yıl için fiyatı
     */
    @ManyToMany(targetEntity = Opportunity.class)
    private List<Opportunity> perYearPrice;

    /**
     * Şehir - Olanak kaydında olanağın tanımlanabileceği max yıl
     */
    @ManyToMany(targetEntity = Opportunity.class)
    private List<Opportunity> topLimitYearValue;

    public CityOpportunity(int id, City cityName, List<Opportunity> opportunity, List<Opportunity> perYearPrice, List<Opportunity> topLimitYearValue) {
        this.id = id;
        this.cityName = cityName;
        this.opportunity = opportunity;
        this.perYearPrice = perYearPrice;
        this.topLimitYearValue = topLimitYearValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCityName() {
        return cityName;
    }

    public void setCityName(City cityName) {
        this.cityName = cityName;
    }

    public List<Opportunity> getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(List<Opportunity> opportunity) {
        this.opportunity = opportunity;
    }

    public List<Opportunity> getPerYearPrice() {
        return perYearPrice;
    }

    public void setPerYearPrice(List<Opportunity> perYearPrice) {
        this.perYearPrice = perYearPrice;
    }

    public List<Opportunity> getTopLimitYearValue() {
        return topLimitYearValue;
    }

    public void setTopLimitYearValue(List<Opportunity> topLimitYearValue) {
        this.topLimitYearValue = topLimitYearValue;
    }

    @Override
    public String toString() {
        return "CityOpportunity{" +
                "id=" + id +
                ", cityName=" + cityName +
                ", opportunity=" + opportunity +
                ", perYearPrice=" + perYearPrice +
                ", topLimitYearValue=" + topLimitYearValue +
                '}';
    }
}
