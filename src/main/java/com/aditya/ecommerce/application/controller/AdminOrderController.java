package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.OrderException;
import com.aditya.ecommerce.application.model.Order;
import com.aditya.ecommerce.application.response.ApiResponse;
import com.aditya.ecommerce.application.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

    private final OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrder();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmedOrder(@PathVariable Long orderId, @RequestHeader("Authorization") String jwt) throws OrderException {
        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> shippedOrder(@PathVariable Long orderId,@RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{orderId}/deliver")
    public ResponseEntity<Order> deliverOrder(@PathVariable Long orderId,@RequestHeader("Authorization") String jwt)throws OrderException{
        Order order = orderService.deliveredOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long orderId,@RequestHeader("Authorization") String jwt) throws OrderException{
        Order order = orderService.cancledOrder(orderId);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Long orderId,@RequestHeader("Authorization") String jwt)throws OrderException{
        orderService.deleteOrder(orderId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Order deleted sucessfully.");
        response.setStatus(true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
