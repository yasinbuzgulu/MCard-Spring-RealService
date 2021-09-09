package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.MainModel.Opportunity;
import org.hibernate.secure.spi.JaccPermissionDeclarations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    Optional<Opportunity> findOpportunityById(Long id);

}
