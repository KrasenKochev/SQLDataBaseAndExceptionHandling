package com.company.oop.cosmetics.exeptions;

public class InvalidUserNotUniqueException extends RuntimeException{
    public InvalidUserNotUniqueException(String message){
        super(message);
    }
}
