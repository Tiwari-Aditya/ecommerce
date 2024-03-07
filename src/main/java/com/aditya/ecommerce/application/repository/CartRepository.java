package com.aditya.ecommerce.application.repository;

import com.aditya.ecommerce.application.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart,Long> {
    @Query("SELECT c FROM Cart c Where c.user.id=:userId ")
    Cart findByUserId(@Param("userId") Long userId);

}
