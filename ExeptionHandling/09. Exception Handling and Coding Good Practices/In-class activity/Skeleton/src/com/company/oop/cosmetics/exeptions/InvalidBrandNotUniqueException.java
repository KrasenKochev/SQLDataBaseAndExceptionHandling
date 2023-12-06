package com.company.oop.cosmetics.exeptions;

public class InvalidBrandNotUniqueException extends RuntimeException{
    public InvalidBrandNotUniqueException(String message){
        super(message);
    }
}
