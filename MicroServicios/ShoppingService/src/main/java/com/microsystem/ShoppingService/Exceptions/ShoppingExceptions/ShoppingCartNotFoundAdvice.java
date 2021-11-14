package com.microsystem.ShoppingService.Exceptions.ShoppingExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShoppingCartNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ShoppingCartNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String shoppingCartNotFoundHandler(ShoppingCartNotFoundException ex){
        return ex.getMessage();
    }
}
