package com.example.MCardSpring.Service;

import com.example.MCardSpring.Exception.CityNotFoundException;
import com.example.MCardSpring.MainModel.City;
import com.example.MCardSpring.Repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public City getCity(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    public void updateCity(City newCity, Long id) {
        City city = cityRepository.findById(id).get();
        System.out.println(city.toString());
        city.setCityName(newCity.getCityName());
    }

    public List<City> listCities() {
        return new ArrayList<>(cityRepository.findAll());
    }

}
