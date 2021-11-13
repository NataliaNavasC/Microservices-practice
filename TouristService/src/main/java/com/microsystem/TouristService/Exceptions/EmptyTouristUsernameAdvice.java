package com.microsystem.TouristService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmptyTouristUsernameAdvice {
    @ResponseBody
    @ExceptionHandler(EmptyTouristUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String emptyTouristUsernameExceptionHandler(EmptyTouristUsernameException ex){
        return ex.getMessage();
    }
}
