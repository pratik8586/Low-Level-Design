package com.restaurent.service;

import com.restaurent.domain.State;

public interface StateService {
    State validateAndGetState(final String stateName);
}
