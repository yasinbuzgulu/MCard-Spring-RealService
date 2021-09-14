package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.CityOpportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface CityOpportunityRepository extends JpaRepository<CityOpportunity, Long> {
    List<CityOpportunity> findAllByCityName(CityOpportunity cityName);
}

