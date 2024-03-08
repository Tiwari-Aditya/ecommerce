package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.model.OrderItem;
import com.aditya.ecommerce.application.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImplementation implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
