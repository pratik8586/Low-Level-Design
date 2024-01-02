package com.restaurent.service;

import com.restaurent.domain.Address;
import com.restaurent.domain.Restaurant;
import com.restaurent.dto.AddressDto;
import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;
import com.restaurent.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll().stream().map(restaurant ->
                        new RestaurantResponse(restaurant.getId(), restaurant.getName(), restaurant.isActive(),
                                restaurant.getAddresses().stream()
                                        .map(address -> new AddressDto(address.getId(), address.getName(),
                                                address.getCity(), address.getState()))
                                        .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }

    @Override
    public Long createRestaurant(final RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.name());

        final Set<Address> addressSet = restaurantRequest.addresses().stream().map(addressDto -> {
            Address address = new Address();
            address.setName(addressDto.name());
            address.setRestaurant(restaurant);
            address.setCity(addressDto.city());
            address.setState(addressDto.state());
            return address;
        }).collect(Collectors.toSet());

        restaurant.setAddresses(addressSet);
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }
}
