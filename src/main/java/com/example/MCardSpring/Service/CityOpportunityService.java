package com.example.MCardSpring.Service;

import com.example.MCardSpring.MainModel.CityOpportunity;
import com.example.MCardSpring.Repository.CityOpportunityRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD işlemlerini yapan servis sınıfım
 */
@Service
public class CityOpportunityService {
    /**
     * Service içinde kullanılacak cityOpportunity repository için instance oluşturmadan constructor ile çağrılır
     */
    CityOpportunityRepository cityOpportunityRepository;
    public CityOpportunityService(CityOpportunityRepository cityOpportunityRepository) {
        this.cityOpportunityRepository = cityOpportunityRepository;
    }

    /**
     * eni şehir-olanak oluşturma metodu
     * @param cityOpportunity: yeni şehir-olanak nesnesi
     * @return: repository ye kayıt döner
     */
    public CityOpportunity createCityOpportunity(CityOpportunity cityOpportunity) {
        return cityOpportunityRepository.save(cityOpportunity);
    }

    /**
     * id ye sahip şehir-olanak kaydını silen metot
     * @param id:siinecek şehir-olanak id si
     */
    public void deleteCityOpportunity(Long id) {
        cityOpportunityRepository.deleteById(id);
    }
            // varsa sil yoksa bulunamadı hatası için kod satırı //
//        if (cityOpportunityRepository.findById(id).isPresent()) {
//            cityOpportunityRepository.deleteById(id);
//        } else  return ResponseEntity.unprocessableEntity().body("Şehir-olanak bulunamadı");

    /**
     * Tüm şehir-olanakları listeleyen metot
     * @return: tüm şehir-olanakları repositoryden bulup döner
     */
    public List<CityOpportunity> listTheCityOpportunities() {
        return new ArrayList<>(cityOpportunityRepository.findAll());
    }

    /**
     * id ye sahip şehir-olanağı bulur
     * @param id: çağırılan şehir-olanağın id si
     * @return: girilen id li şehir-olanağı döner
     */
    public CityOpportunity getCityOpportunityById(Long id) {
        return cityOpportunityRepository.findById(id).get();
    }

    /**
     * Şehir-olanağın bilgi güncellemesini yapan sınıf
     * @param newCityOpportunity: güncellenmiş yeni şehir-olanak nesnesi
     * @param id: düzenlemenin yapıldığı şehir-olanak id si
     */
    public void updateCityOpportunity(CityOpportunity newCityOpportunity, Long id) {
        CityOpportunity cityOpportunity = cityOpportunityRepository.findById(id).get();
        System.out.println(cityOpportunity.toString());
        cityOpportunity.setId(newCityOpportunity.getId());
            cityOpportunity.setCity(newCityOpportunity.getCity());
            cityOpportunity.setOpportunity(newCityOpportunity.getOpportunity());
        cityOpportunityRepository.save(cityOpportunity);
    }

}
