package com.restaurent.service;

import com.restaurent.domain.City;

public interface CityService {
    City validateAndGetCity(final String cityName);
}
