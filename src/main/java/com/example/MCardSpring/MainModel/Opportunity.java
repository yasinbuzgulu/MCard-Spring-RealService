package com.example.MCardSpring.MainModel;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Olanak nesnesinin özelliklerini belirten entity
 */
@Entity
public class Opportunity {
    /**
     * Olanak kaydının tutulduğu unique ID
     */
    @Id
    private Long id;

    /**
     * Olanağın ismi
     */
    private String name;

    /**
     * Olanağın 1 yıl için fiyatı
     */
    private int perYearPrice;

    /**
     * Olanağın tanımlanabileceği max yıl
     */
    private int topLimitYearValue;

    public Opportunity(Long id, String name, int perYearPrice, int topLimitYearValue) {
        this.id = id;
        this.name = name;
        this.perYearPrice = perYearPrice;
        this.topLimitYearValue = topLimitYearValue;
    }

    public Opportunity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", perYearPrice=" + perYearPrice +
                ", topLimitYearValue=" + topLimitYearValue +
                '}';
    }
}
