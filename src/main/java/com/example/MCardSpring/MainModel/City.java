package com.example.MCardSpring.MainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Şehir nesnesinin özelliklerini belirten entity
 */
@Entity
public class City {
    /**
     * Şehir nesnesinin unique id si
     */
    @Id
    @GeneratedValue
    private  Long id;

    /**
     * Şehrin ismi
     */
    private String cityName;

    public City( Long id, String cityName) {
        this.cityName = cityName;
        this.id = id;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
