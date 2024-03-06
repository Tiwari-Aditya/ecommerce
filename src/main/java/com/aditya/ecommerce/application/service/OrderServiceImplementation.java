package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.OrderException;
import com.aditya.ecommerce.application.model.Address;
import com.aditya.ecommerce.application.model.Order;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImplementation implements OrderService{
    private final CartRepository cartRepository;
    private final CartService cartItemService;
    private final ProductService productService;
    @Override
    public Order createOrder(User user, Address shippingAddress) {
        return null;
    }

    @Override
    public List<Order> findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> userOrderHistory(Long userId) {
        return null;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order cancledOrder(Long orderId) throws OrderException {
        return null;
    }
}
