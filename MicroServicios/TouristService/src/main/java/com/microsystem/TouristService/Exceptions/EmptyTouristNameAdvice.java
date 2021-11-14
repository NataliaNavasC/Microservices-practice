package com.microsystem.TouristService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmptyTouristNameAdvice {
    @ResponseBody
    @ExceptionHandler(EmptyTouristNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String emptyTouristNameExceptionHandler(EmptyTouristNameException ex){
        return ex.getMessage();
    }
}
