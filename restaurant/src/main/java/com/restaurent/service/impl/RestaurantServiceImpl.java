package com.restaurent.service.impl;

import com.restaurent.domain.Address;
import com.restaurent.domain.Restaurant;
import com.restaurent.dto.AddressDto;
import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;
import com.restaurent.repository.RestaurantRepository;
import com.restaurent.service.CityService;
import com.restaurent.service.CountryService;
import com.restaurent.service.RestaurantService;
import com.restaurent.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @Override
    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll().stream().map(restaurant ->
                        new RestaurantResponse(restaurant.getId(), restaurant.getName(), restaurant.isActive(),
                                restaurant.getAddresses().stream()
                                        .map(address -> new AddressDto(address.getId(), address.getAddressLine1(),
                                                address.getAddressLine2(), address.getStreet(), address.getLandmark(),
                                                address.getCity().getName(), address.getState().getName(), address.getCountry().getName()))
                                        .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }

    @Override
    public UUID createRestaurant(final RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.name());
        restaurant.setActive(true);

        final Set<Address> addressSet = restaurantRequest.addresses().stream().map(addressDto -> {
            Address address = new Address();
            address.setRestaurant(restaurant);
            address.setAddressLine1(addressDto.addressLine1());
            address.setAddressLine2(addressDto.addressLine2());
            address.setLandmark(addressDto.landmark());
            address.setCity(cityService.validateAndGetCity(addressDto.city()));
            address.setState(stateService.validateAndGetState(addressDto.state()));
            address.setCountry(countryService.validateAndGetCountry(addressDto.country()));
            return address;
        }).collect(Collectors.toSet());

        restaurant.setAddresses(addressSet);
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }
}
