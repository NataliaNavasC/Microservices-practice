package com.microsystem.TouristService.Exceptions;

public class EmptyTouristUsernameException extends RuntimeException{
    public EmptyTouristUsernameException(){
        super("Username cannot be empty!");
    }
}
