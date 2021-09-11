package com.example.MCardSpring.MainModel;

import javax.persistence.Entity;
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
    private  Long id;

    /**
     * Şehrin ismi
     */
    private String cityName;

    public City(Long id, String cityName) {
        this.id = id;
        this.cityName = cityName;
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
