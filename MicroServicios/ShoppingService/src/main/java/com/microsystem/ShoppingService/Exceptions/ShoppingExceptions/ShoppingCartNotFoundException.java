package com.microsystem.ShoppingService.Exceptions.ShoppingExceptions;

public class ShoppingCartNotFoundException extends RuntimeException {
    public ShoppingCartNotFoundException(String username){
        super("Shopping cart for user " + username + " not found!");
    }

    public ShoppingCartNotFoundException(long id){
        super("Shopping cart with " + id + " not found!");
    }
}
