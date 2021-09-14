package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.MainModel.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Şehir bilgilerinin tutulduğu repository
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long > { }
