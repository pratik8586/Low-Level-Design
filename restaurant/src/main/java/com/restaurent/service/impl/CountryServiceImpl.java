package com.restaurent.service.impl;

import com.restaurent.domain.Country;
import com.restaurent.repository.CountryRepository;
import com.restaurent.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country validateAndGetCountry(String countryName) {
        return countryRepository.findByName(countryName).orElseThrow(() -> new RuntimeException("Invalid country"));
    }
}
