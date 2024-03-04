package com.aditya.ecommerce.application.exception;

import com.aditya.ecommerce.application.model.User;

public class UserException extends Exception {
    public UserException(String message){
        super(message);
    }
}
