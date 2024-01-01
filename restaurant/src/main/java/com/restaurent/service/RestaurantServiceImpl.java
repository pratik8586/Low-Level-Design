package com.restaurent.service;

import com.restaurent.domain.Restaurant;
import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;
import com.restaurent.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantResponse> findAllRestaurants() {
        return restaurantRepository.findAll().stream().map(restaurant ->
                        new RestaurantResponse(restaurant.getId(), restaurant.getName(), restaurant.isActive()))
                .collect(Collectors.toList());
    }

    @Override
    public Long createRestaurant(final RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.name());
        restaurant.setAddresses(restaurantRequest.addresses());
        restaurantRepository.save(restaurant);
        return restaurant.getId();
    }
}
