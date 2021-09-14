package com.example.MCardSpring.Controller;

import com.example.MCardSpring.MainModel.Card;
import com.example.MCardSpring.MainModel.CityOpportunity;
import com.example.MCardSpring.Service.CityOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CityOpportunityController {

    private final CityOpportunityService cityOpportunityService;

    public CityOpportunityController(CityOpportunityService cityOpportunityService) {
        this.cityOpportunityService = cityOpportunityService;
    }
    
    @GetMapping("/cityOpportunities")
    public CollectionModel<EntityModel<CityOpportunity>> listTheCityOpportunities() {
        List<EntityModel<CityOpportunity>> cityOpportunities = cityOpportunityService.listTheCityOpportunities();
        return CollectionModel.of(cityOpportunities, linkTo(methodOn(CityOpportunityController.class)
                .listTheCityOpportunities()).withSelfRel());
    }

    @GetMapping("/cityOpportunities/{id}")
    public EntityModel<CityOpportunity> getCityOpportunityById(@PathVariable Long id) {
        CityOpportunity cityOpportunity = cityOpportunityService.getCityOpportunityById(id);

        return EntityModel.of(cityOpportunity,
                linkTo(methodOn(CityOpportunityController.class).getCityOpportunityById(id)).withSelfRel(),
                linkTo(methodOn(CityOpportunityController.class).listTheCityOpportunities()).withRel("cityOpportunities"));
    }

    @PostMapping("cityOpportunities/")
    public ResponseEntity<Object> createCityOpportunity (@RequestBody CityOpportunity cityOpportunity) {
        return cityOpportunityService.createCityOpportunity(cityOpportunity);
    }

    @PutMapping("/cityOpportunities/{id}")
    public EntityModel<CityOpportunity> updateCityOpportunity(@RequestBody CityOpportunity newCityOpportunity,
                                                              @PathVariable Long id) {
        CityOpportunity cityOpportunity = cityOpportunityService.updateCityOpportunity(newCityOpportunity, id);
        return EntityModel.of(cityOpportunity,
                linkTo(methodOn(CityOpportunityController.class).getCityOpportunityById(id)).withSelfRel(),
                linkTo(methodOn(CityOpportunityController.class).listTheCityOpportunities()).withRel("cityOpportunities"));
    }

    @DeleteMapping("cityOpportunities/{id}")
    public ResponseEntity<Object> deleteCard (@PathVariable Long id) {
        return cityOpportunityService.deleteCityOpportunity(id);
    }

}
