package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.City;
import com.example.MCardSpring.Repository.CityRepository;
import com.example.MCardSpring.Service.CityService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CityController {

    /**
     * Controller içinde kullanılacak city serivisi instance oluşturmadan constructor ile çağrılır (inject edilir)
     */
    CityService cityService;
    CityRepository cityRepository;

    public CityController(CityService cityService, CityRepository cityRepository) {
        this.cityService = cityService;
        this.cityRepository = cityRepository;
    }

    /**
     * GET ile tüm city ler çağırılır
     *
     * @return: cities (kayıtlı tüm şehirler)
     */
    @GetMapping("/cities")
    public ResponseEntity<List<City>> listCities() {
        List<City> cities = cityService.listCities();
        return ResponseEntity.ok().body(cities);
    }

    /**
     * GET ile ve URI da id ile sadece bir city çağırılır
     *
     * @param id : çağırılacak city nin ID si
     * @return : URI da girilen id değerine sahip city yi döndürür
     */
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityService.getCityById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    /**
     * POST ile yeni bir city(şehir) oluşturulur
     *
     * @param city : yeni oluşturulan şehir
     * @return : newVity(yeni kaydedilen city)
     */
    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        city = cityService.createCity(city);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("city", "/cities/" + city.getId().toString());
        return new ResponseEntity<>(city, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * PUT ile ilgili ID ye sahip city düzenlenir
     *
     * @param city: şehrin düzenlenmiş son hali
     * @param id:   düzenleme işleminin yapılacağı şehir id si
     * @return : girilen id ye sahip şehrin güncellemesini döndürür
     */
    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@RequestBody City city, @PathVariable("id") Long id) {
        cityService.updateCity(city, id);
        return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
    }

    /**
     * @param id: silinecek şehrin id ' si
     * @return: status u 204 döner ("No Content")
     */
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
