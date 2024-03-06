package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Cart;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService {


    @Override
    public Cart creatCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException {
        return null;
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
