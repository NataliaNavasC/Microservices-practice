package com.microsystem.TouristService.Exceptions;

public class TouristNotFoundException extends RuntimeException{
    public TouristNotFoundException(int id){
        super("Tourist with id " + id + " not found!");
    }
    
    public TouristNotFoundException(String username){
        super("Tourist with username " + username + " not found!");
    }
}
