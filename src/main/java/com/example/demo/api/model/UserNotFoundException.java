package com.example.demo.api.model;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Book id not found : " + id);
    }

}
