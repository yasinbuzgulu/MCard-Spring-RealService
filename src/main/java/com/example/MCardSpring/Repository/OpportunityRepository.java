package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Olanak bilgilerinin tutulduğu repository
 */
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
