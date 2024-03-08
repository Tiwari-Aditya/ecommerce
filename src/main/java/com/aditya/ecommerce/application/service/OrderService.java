package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.OrderException;
import com.aditya.ecommerce.application.model.Address;
import com.aditya.ecommerce.application.model.Order;
import com.aditya.ecommerce.application.model.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, Address shippingAddress);
    Order findOrderById(Long orderId) throws OrderException;
    List<Order> userOrderHistory(Long userId);
    Order placedOrder(Long orderId) throws OrderException;
    Order confirmedOrder(Long orderId) throws OrderException;
    Order shippedOrder(Long orderId) throws OrderException;
    Order deliveredOrder(Long orderId) throws OrderException;
    Order cancledOrder(Long orderId) throws OrderException;
    List<Order> getAllOrder();
    void deleteOrder(Long orderId)throws OrderException;
}
