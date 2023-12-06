package com.company.oop.cosmetics.exeptions;

public class InvalidProductNotExistException extends RuntimeException{
    public InvalidProductNotExistException(String message){
        super(message);
    }
}
