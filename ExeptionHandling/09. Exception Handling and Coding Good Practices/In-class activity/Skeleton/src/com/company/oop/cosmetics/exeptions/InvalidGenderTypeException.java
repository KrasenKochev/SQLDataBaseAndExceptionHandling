package com.company.oop.cosmetics.exeptions;

public class InvalidGenderTypeException extends RuntimeException{
    public InvalidGenderTypeException(String message){
        super(message);
    }
}
