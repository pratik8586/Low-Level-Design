package com.restaurent.service.impl;

import com.restaurent.domain.City;
import com.restaurent.repository.CityRepository;
import com.restaurent.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City validateAndGetCity(final String cityName) {
        return cityRepository.findByName(cityName).orElseThrow(() -> new RuntimeException("Invalid City"));
    }
}
