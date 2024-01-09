package com.restaurent.service.impl;

import com.restaurent.domain.State;
import com.restaurent.repository.StateRepository;
import com.restaurent.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State validateAndGetState(final String stateName) {
        return stateRepository.findByName(stateName).orElseThrow(() -> new RuntimeException("Invalid state"));
    }
}