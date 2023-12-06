package com.company.oop.cosmetics.exeptions;

public class InvalidNameLengthException extends RuntimeException{

    public InvalidNameLengthException(String message){
        super(message);
    }
}
