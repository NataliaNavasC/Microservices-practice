package com.microsystem.ShoppingService.Exceptions.ShoppingExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShoppingCartUsernameEmptyAdvice {
    @ResponseBody
    @ExceptionHandler(ShoppingCartUsernameEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String shoppingCartUsernameEmptyHandler(ShoppingCartUsernameEmptyException ex){
        return ex.getMessage();
    }
}
