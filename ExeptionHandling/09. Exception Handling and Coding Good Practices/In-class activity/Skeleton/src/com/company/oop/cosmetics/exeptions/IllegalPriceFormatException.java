package com.company.oop.cosmetics.exeptions;

public class IllegalPriceFormatException extends RuntimeException{
    public IllegalPriceFormatException(String message){
        super(message);
    }
}
