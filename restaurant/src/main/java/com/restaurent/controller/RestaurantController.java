package com.restaurent.controller;

import com.restaurent.dto.RestaurantRequest;
import com.restaurent.dto.RestaurantResponse;
import com.restaurent.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantResponse> getAllRestaurants(){
        return restaurantService.findAllRestaurants();
    }

    @PostMapping("/add")
    public Long createRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.createRestaurant(restaurantRequest);
    }
}
