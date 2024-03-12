package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Cart;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.AddItemRequest;

public interface CartService {
    Cart createCart(User user);
    String addCartItem(Long userId, AddItemRequest request) throws ProductException;

    Cart findUserCart(Long userId);


}
