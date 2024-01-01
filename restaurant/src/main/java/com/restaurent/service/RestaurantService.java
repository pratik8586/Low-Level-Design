package com.restaurent.service;

import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponse> findAllRestaurants();

    Long createRestaurant(final RestaurantRequest restaurantRequest);
}