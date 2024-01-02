package com.restaurent.dto;

import java.util.Set;

public record RestaurantResponse (Long id, String name, boolean isActive, Set<AddressDto> addresses) {
}
