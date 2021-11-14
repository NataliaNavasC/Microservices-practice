package com.microsystem.ShoppingService.Exceptions.ShoppingExceptions;

public class ShoppingCartUsernameEmptyException extends RuntimeException{
    public ShoppingCartUsernameEmptyException(){
        super("The username must not be empty");
    }
}
