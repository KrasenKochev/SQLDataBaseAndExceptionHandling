package com.company.oop.cosmetics.exeptions;

public class InvalidCategoryNotExistException extends RuntimeException{
    public InvalidCategoryNotExistException(String message){
        super(message);
    }
}
