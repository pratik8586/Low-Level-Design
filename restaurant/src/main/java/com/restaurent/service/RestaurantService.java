package com.restaurent.service;

import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {
    List<RestaurantResponse> findAllRestaurants();

    UUID createRestaurant(final RestaurantRequest restaurantRequest);
}