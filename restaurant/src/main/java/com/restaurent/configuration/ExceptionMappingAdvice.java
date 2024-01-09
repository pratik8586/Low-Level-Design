package com.restaurent.configuration;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionMappingAdvice {

    @ResponseBody
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolations(final ConstraintViolationException e) {
        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
