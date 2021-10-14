package com.example.MCardSpring.Service;

import com.example.MCardSpring.Exception.CityNotFoundException;
import com.example.MCardSpring.MainModel.City;
import com.example.MCardSpring.Repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CityService {
    CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }


    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public void updateCity(City newCity, Long id) {
        City city = cityRepository.findById(id).get();
        city.setCityName(newCity.getCityName());
        cityRepository.save(city);
    }

    public List<City> listCities() {
        return new ArrayList<>(cityRepository.findAll());
    }

}
