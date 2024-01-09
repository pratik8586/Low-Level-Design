package com.restaurent.controller;

import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;
import com.restaurent.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/list")
    public List<RestaurantResponse> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @PostMapping("/create")
    public UUID createRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }
}
