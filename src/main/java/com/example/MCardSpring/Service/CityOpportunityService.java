package com.example.MCardSpring.Service;

import com.example.MCardSpring.Controller.CardController;
import com.example.MCardSpring.Controller.CityOpportunityController;
import com.example.MCardSpring.Exception.CardNotFoundException;
import com.example.MCardSpring.Exception.CityOpportunityNotFoundException;
import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.MainModel.CityOpportunity;
import com.example.MCardSpring.Repository.CityOpportunityRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CityOpportunityService {

    private final CityOpportunityRepository cityOpportunityRepository;

    public CityOpportunityService(CityOpportunityRepository cityOpportunityRepository) {
        this.cityOpportunityRepository = cityOpportunityRepository;
    }

    public ResponseEntity<Object> createCityOpportunity(CityOpportunity cityOpportunity) {
        if (cityOpportunityRepository.findById(cityOpportunity.getId()).isPresent()) {
            System.out.println("Bu Şehir-olanak kaydı zaten mevcut");
            return ResponseEntity.badRequest().body("Mevcut şehir-olanak!!, Şehir-olanak kaydı yapılamadı");
        } else {
            cityOpportunityRepository.save(cityOpportunity);
        }
        return null;
    }

    public ResponseEntity<Object> deleteCityOpportunity(Long id) {

        if (cityOpportunityRepository.findById(id).isPresent()) {
            cityOpportunityRepository.deleteById(id);
        } else {
            return ResponseEntity.unprocessableEntity().body("Şehir-olanak bulunamadı");
        }
        return null;
    }

    @Transactional
    public CityOpportunity updateCityOpportunity(CityOpportunity newCityOpportunity, Long id) {
        return cityOpportunityRepository.findById(id)
                .map(cityOpportunity -> {
                    cityOpportunity.setId(newCityOpportunity.getId());
                    cityOpportunity.setCityName(newCityOpportunity.getCityName());
                    cityOpportunity.setOpportunity(newCityOpportunity.getOpportunity());
                    cityOpportunity.setPerYearPrice(newCityOpportunity.getPerYearPrice());
                    cityOpportunity.setTopLimitYearValue(newCityOpportunity.getTopLimitYearValue());
                    return cityOpportunityRepository.save(cityOpportunity);
                })
                .orElseGet(() -> {
                    newCityOpportunity.setId(id);
                    return cityOpportunityRepository.save(newCityOpportunity);
                });
    }

    public List<EntityModel<CityOpportunity>> listTheCityOpportunities() {
        return cityOpportunityRepository.findAll().stream()
                .map(cityOpportunity -> EntityModel.of(cityOpportunity,
                        linkTo(methodOn(CityOpportunityController.class).getCityOpportunityById(cityOpportunity.getId())).withSelfRel(),
                        linkTo(methodOn(CityOpportunityController.class).listTheCityOpportunities()).withRel("cityOpportunities")))
                .collect(Collectors.toList());
    }
    public CityOpportunity getCityOpportunityById(Long id) {
        return cityOpportunityRepository.findById(id)
                .orElseThrow(() -> new CityOpportunityNotFoundException(id));
    }

}
