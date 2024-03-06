package com.aditya.ecommerce.application.repository;

import com.aditya.ecommerce.application.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {
}
