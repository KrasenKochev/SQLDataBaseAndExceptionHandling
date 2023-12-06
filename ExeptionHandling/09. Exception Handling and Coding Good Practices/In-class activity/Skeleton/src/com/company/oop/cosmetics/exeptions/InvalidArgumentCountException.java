package com.company.oop.cosmetics.exeptions;

public class InvalidArgumentCountException extends RuntimeException{
    public InvalidArgumentCountException(String message){
        super(message);
    }
}
