package com.company.oop.cosmetics.exeptions;

public class InvalidPriceRangeException extends RuntimeException{
    public InvalidPriceRangeException(String message){
        super(message);
    }
}
