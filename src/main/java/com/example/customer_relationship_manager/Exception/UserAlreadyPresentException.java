package com.example.customer_relationship_manager.Exception;

public class UserAlreadyPresentException extends RuntimeException{
    public UserAlreadyPresentException(String message){
        super(message);
    }
}
