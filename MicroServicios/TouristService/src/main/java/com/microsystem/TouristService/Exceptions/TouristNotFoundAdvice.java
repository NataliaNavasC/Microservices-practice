package com.microsystem.TouristService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TouristNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TouristNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String touristNotFoundHandler(TouristNotFoundException ex){
        return ex.getMessage();
    }
}
