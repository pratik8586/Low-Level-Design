package com.restaurent.dto;

import com.restaurent.domain.Address;
import lombok.NonNull;

import java.util.Set;

public record RestaurantRequest(@NonNull String name, @NonNull Set<Address> addresses) {
}
