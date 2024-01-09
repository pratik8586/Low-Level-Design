package com.restaurent.dto;

import java.util.Set;
import java.util.UUID;

public record RestaurantResponse(UUID id, String name, boolean isActive, Set<AddressDto> addresses) {
}
