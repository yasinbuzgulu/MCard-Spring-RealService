package com.example.MCardSpring.Repository;

import com.example.MCardSpring.MainModel.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Optional<Applicant> findByCitizenNumber(Long citizenNumber);

}
