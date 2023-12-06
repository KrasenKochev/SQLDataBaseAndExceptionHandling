package com.company.oop.cosmetics.exeptions;

public class InvalidBrandLengthException extends RuntimeException   {
    public InvalidBrandLengthException (String message){
        super(message);
    }
}
