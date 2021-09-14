package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Applicant (başvuran) ile ilgili CRUD işlemlerinin (PUT/GET/POST/DELETE) yapıldığı kısım
 */
@RestController
public
class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    /**
     * GET ile tüm applicant(başvuran) lar çağırılır
     * @return: applicants (kayıtlı tüm başvuranlar)
     */
    @GetMapping("/applicants")
    public CollectionModel<EntityModel<Applicant>> listTheApplicants() {
        List<EntityModel<Applicant>> applicants = applicantService.listTheApplicants();
        return CollectionModel.of(applicants, linkTo(methodOn(ApplicantController.class)
                .listTheApplicants()).withSelfRel());
    }

    /**
     * POST ile yeni bir applicant(başvuran) oluşturulur
     * @param newApplicant : yeni oluşturulan başvuran
     * @return : newApplicant(yeni kaydedilen applicant)
     */
    @PostMapping("/applicants")
    ResponseEntity<ResponseEntity<String>> newApplicant(@RequestBody Applicant newApplicant) {
        return ResponseEntity.ok(applicantService.createApplicant(newApplicant));
    }

    /**
     * GET ile ve URI da id ile sadece bir applicant çağırılır
     * @param id : çağğırılacak applicant ın ID si
     * @return : URI da girilen id değerine sahip başvuranyı döndürür
     */
    @GetMapping("/applicants/{id}")
    public EntityModel<Applicant> getApplicantById(@PathVariable Long id) {
        Applicant applicant = applicantService.getApplicantById(id);

        return EntityModel.of(applicant,
                linkTo(methodOn(ApplicantController.class).getApplicantById(id)).withSelfRel(),
                linkTo(methodOn(ApplicantController.class).listTheApplicants()).withRel("preschools"));
    }

    /**
     * PUT ile ilgili ID ye sahip applicant düzenlenir
     * @param newApplicant: başvurannın düzenlenmiş son hali
     * @param id:           düzenleme işleminin yapılacağı başvuran id si
     * @return : girilen id ye sahip başvurannın güncellemesini döndürür
     */
    @PutMapping("/applicants/{id}")
    public EntityModel<Applicant> updateApplicant(@RequestBody Applicant newApplicant, @PathVariable Long id) {
        Applicant applicant = applicantService.updateApplicant(newApplicant, id);
        return EntityModel.of(applicant,
                linkTo(methodOn(ApplicantController.class).getApplicantById(id)).withSelfRel(),
                linkTo(methodOn(ApplicantController.class).listTheApplicants()).withRel("applicants"));
    }

    /**
     * DELETE le başvuran silinir
     * @param id: silinecek başvurannın id ' si
     */
    @DeleteMapping("/applicants/{id}")
    void deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
    }

}
