package com.restaurent.service;

import com.restaurent.domain.Country;

public interface CountryService {
    Country validateAndGetCountry(final String countryName);
}
