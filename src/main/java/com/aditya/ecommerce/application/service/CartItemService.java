package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.CartItemException;
import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.Cart;
import com.aditya.ecommerce.application.model.CartItem;
import com.aditya.ecommerce.application.model.Product;

public interface CartItemService {
    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    void removeCartItem(Long userId, Long cartItemId) throws CartItemException , UserException;

    CartItem findCartItemById(Long cartItemId) throws CartItemException;

}
