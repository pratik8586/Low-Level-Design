package com.restaurent.dto;

import lombok.NonNull;

import java.util.Set;

public record RestaurantRequest(@NonNull String name, @NonNull Set<AddressDto> addresses) {
}
