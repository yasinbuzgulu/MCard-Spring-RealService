package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.Service.ApplicantService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Applicant (başvuran) ile ilgili CRUD işlemlerinin (PUT/GET/POST/DELETE) yapıldığı sınıf
 */
@RestController
public class ApplicantController {
    /**
     * Controller içinde kullanılacak applicant serivisi instance oluşturmadan constructor ile çağrılır
     */
    ApplicantService applicantService;
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    /**
     * GET ile tüm applicant(başvuran) lar çağırılır
     * @return: applicants (kayıtlı tüm başvuranlar)
     */
    @GetMapping("/applicants")
    public ResponseEntity<List<Applicant>> listTheApplicants() {
        List<Applicant> applicants = applicantService.listTheApplicants();
        return ResponseEntity.ok().body(applicants);
    }

    /**
     * GET ile ve URI da id ile sadece bir applicant çağırılır
     * @param id : çağğırılacak applicant ın ID si
     * @return : URI da girilen id değerine sahip başvuranyı döndürür
     */
    @GetMapping("/applicants/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        return new ResponseEntity<>(applicantService.getApplicantById(id), HttpStatus.OK);
    }

    /**
     * POST ile yeni bir applicant(başvuran) oluşturulur
     * @param applicant : yeni oluşturulan başvuran
     * @return : newApplicant(yeni kaydedilen applicant)
     */
    @PostMapping("/applicants")
    public ResponseEntity<Applicant> createApplicant(@RequestBody Applicant applicant) {
        Applicant applicant1 = applicantService.createApplicant(applicant);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("applicant", "/applicants/" + applicant1.getId().toString());
        return new ResponseEntity<>(applicant, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * PUT ile ilgili ID ye sahip applicant düzenlenir
     * @param applicant: başvurannın düzenlenmiş son hali
     * @param id:           düzenleme işleminin yapılacağı başvuran id si
     * @return : girilen id ye sahip başvurannın güncellemesini döndürür
     */
    @PutMapping("/applicants/{id}")
    public ResponseEntity<Applicant> updateApplicant( @RequestBody Applicant applicant , @PathVariable("id") Long id) {
        applicantService.updateApplicant(applicant, id);
        return new ResponseEntity<>(applicantService.getApplicantById(id), HttpStatus.OK);
    }

    /**
     *
     * @param id:
     */
    /**
     * DELETE le başvuran silinir
     * @param id: silinecek başvurannın id ' si
     * @return:  status u 204 döner ("No Content")
     */
    @DeleteMapping("/applicants/{id}")
    public ResponseEntity<Applicant> deleteApplicant(@PathVariable("id") Long id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
