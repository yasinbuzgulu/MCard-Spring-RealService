package com.example.MCardSpring.MainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Şehir - Olanak kaydında şehrin ismi
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
