package com.example.customer_relationship_manager.Exception;

public class UserIsNotPresentException extends RuntimeException {
    public UserIsNotPresentException(String message) {
        super(message);
    }
}
