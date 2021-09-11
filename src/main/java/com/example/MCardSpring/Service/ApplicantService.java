package com.example.MCardSpring.Service;

import com.example.MCardSpring.MainModel.Applicant;
import com.example.MCardSpring.Repository.ApplicantRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 *  CRUD işlemlerini yapan servis sınıfım
 */
@Service
public class ApplicantService {
    /**
     * Service içinde kullanılacak applicant repository için instance oluşturmadan constructor ile çağrılır
     */
    ApplicantRepository applicantRepository;
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    /**
     * Yeni başvuran oluşturma metodu
     * @param applicant: yeni başvuran nesnesi
     * @return: repository ye kayıt döner
     */
    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);

    }

    /**
     * id ye sahip başvuranı silen metot
     * @param id: siinecek başvuran id si
     */
    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }

    /**
     * Tüm başvuranları listeleyen metot
     * @return: tüm başvuranları repositoryden bulup döner
     */
    public List<Applicant> listTheApplicants() {
        return new ArrayList<>(applicantRepository.findAll());
    }

    /**
     * id ye sahip başvuranı bulur
     * @param id: çağırılan başvuranın id si
     * @return: girilen id li başvuranı döner
     */
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id).get();
    }

    /**
     * Başvuranın bilgi güncellemesini yapan sınıf
     * @param newApplicant: güncellenmiş yeni başvuran nesnesi
     * @param id: düzenlemenin yapıldığı başvuranın id si
     */
    public void updateApplicant(Applicant newApplicant, Long id) {
        Applicant applicant = applicantRepository.findById(id).get();
        System.out.println(applicant.toString());
        applicant.setId(newApplicant.getId());
            applicant.setName(newApplicant.getName());
            applicant.setSurname(newApplicant.getSurname());
            applicant.setBirthDate(newApplicant.getBirthDate());
            applicant.setCitizenNumber(newApplicant.getCitizenNumber());
            applicant.setTypeBasedOnAge(newApplicant.getTypeBasedOnAge());
            applicant.setTypeBasedOnEducation(newApplicant.getTypeBasedOnEducation());
        applicantRepository.save(applicant);
    }

}