package com.aditya.ecommerce.application.service;


import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.User;

public interface UserService {

     User findUserById(Long userId) throws UserException;
     User findUserProfileByJwt(String jwt) throws UserException;
}
