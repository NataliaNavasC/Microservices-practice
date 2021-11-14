package com.microsystem.TouristService.Exceptions;

public class EmptyTouristNameException extends RuntimeException {
    public EmptyTouristNameException(){
        super("Name cannot be empty!");
    }
}
