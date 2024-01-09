package com.restaurent.dto;

import java.util.UUID;

public record AddressDto(UUID id, String addressLine1, String addressLine2, String street,
                         String landmark, String city, String state, String country) {
}
