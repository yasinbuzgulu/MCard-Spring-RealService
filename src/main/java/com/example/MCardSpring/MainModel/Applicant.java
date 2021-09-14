package com.example.MCardSpring.MainModel;

import com.sun.istack.NotNull;

import javax.persistence.*;

/**
 * Başvuran kişinin özelliklerini belirten entity
 */
@Entity
public class Applicant {

    /**
     * Başvuran kişinin kaydının tutulduğu unique ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Başvuran kişinin kaydında başvuranın ismi
     */
    @NotNull
    private String name;

    /**
     * Başvuran kişinin kaydında başvuranın soyismi
     */
    @NotNull
    private String surname;

    /**
     * Başvuran kişinin kaydında başvuranın doğum tarihi
     */
    @NotNull
    private String birthDate;

    /**
     * Başvuran kişinin kaydında başvuranın kimlik numarası
     */
    @NotNull
    private long citizenNumber;

    /**
     * Başvuran kişinin kaydında başvuranın yaşına göre tipi (çocuk/normal/yaşlı)
     */
    @NotNull
    private String typeBasedOnAge;

    /**
     * Başvuran kişinin kaydında başvuranın eğitime göre tipi (öğrenci/sivil/ikisi de değil)
     */
    @NotNull
    private String typeBasedOnEducation;

    public Applicant() {
    }

    public Applicant(String name, String surname, String birthDate,
                     long citizenNumber, String typeBasedOnAge, String typeBasedOnEducation, Long id) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.citizenNumber = citizenNumber;
        this.typeBasedOnAge = typeBasedOnAge;
        this.typeBasedOnEducation = typeBasedOnEducation;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(long citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public String getTypeBasedOnAge() {
        return typeBasedOnAge;
    }

    public void setTypeBasedOnAge(String typeBasedOnAge) {
        this.typeBasedOnAge = typeBasedOnAge;
    }

    public String getTypeBasedOnEducation() {
        return typeBasedOnEducation;
    }

    public void setTypeBasedOnEducation(String typeBasedOnEducation) {
        this.typeBasedOnEducation = typeBasedOnEducation;
    }

    @Override
    public String toString() {
        return  "Applicant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", citizenNumber=" + citizenNumber +
                ", typeBasedOnAge='" + typeBasedOnAge + '\'' +
                ", typeBasedOnEducation='" + typeBasedOnEducation + '\'' +
                '}';
    }
}
