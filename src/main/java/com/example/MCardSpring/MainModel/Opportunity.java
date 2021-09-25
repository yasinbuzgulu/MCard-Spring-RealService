package com.example.MCardSpring.MainModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;

    /**
     * Olanağın ismi
     */
    private String name;

    public Opportunity( String name) {
        this.name = name;
    }

    public Opportunity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                '}';
    }
}
