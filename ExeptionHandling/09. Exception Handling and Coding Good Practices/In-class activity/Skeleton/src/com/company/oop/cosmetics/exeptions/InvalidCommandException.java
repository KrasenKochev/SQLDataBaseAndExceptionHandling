package com.company.oop.cosmetics.exeptions;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException(String message){
        super(message);
    }
}
