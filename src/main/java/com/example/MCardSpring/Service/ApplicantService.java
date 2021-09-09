package com.example.MCardSpring.Service;

import com.example.MCardSpring.Controller.ApplicantController;
import com.example.MCardSpring.Exception.ApplicantNotFoundException;
import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public ResponseEntity<String> createApplicant(Applicant applicant) {
        if (applicantRepository.findById(applicant.getCitizenNumber()).isPresent()) {
            System.out.println("Bu ID zaten mevcut");
            return ResponseEntity.badRequest().body("Girilen ID zaten mevcuttur, Kullanıcı başvurusu yapılamadı");
        } else {
            applicantRepository.save(applicant);
        }
        return null;
    }

    public List<Applicant> findAll() {
        return null;
    }

    public List<EntityModel<Applicant>> listTheApplicants() {
        {
            return applicantRepository.findAll().stream()
                    .map(applicant -> EntityModel.of(applicant,
                            linkTo(methodOn(ApplicantController.class).getApplicantById(applicant.getId())).withSelfRel(),
                            linkTo(methodOn(ApplicantController.class).listTheApplicants()).withRel("applicants")))
                    .collect(Collectors.toList());
        }

    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new ApplicantNotFoundException(id));
    }

    @Transactional
    public Applicant updateApplicant(Applicant newApplicant, Long id) {
        return applicantRepository.findById(id)
                .map(applicant -> {
                    applicant.setId(newApplicant.getId());
                    applicant.setName(newApplicant.getName());
                    applicant.setSurname(newApplicant.getSurname());
                    applicant.setBirthDate(newApplicant.getBirthDate());
                    applicant.setCitizenNumber(newApplicant.getCitizenNumber());
                    applicant.setTypeBasedOnAge(newApplicant.getTypeBasedOnAge());
                    applicant.setTypeBasedOnEducation(newApplicant.getTypeBasedOnEducation());
                    return applicantRepository.save(applicant);
                })
                .orElseGet(() -> {
                    newApplicant.setId(id);
                    return applicantRepository.save(newApplicant);
                });
    }

    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }
}