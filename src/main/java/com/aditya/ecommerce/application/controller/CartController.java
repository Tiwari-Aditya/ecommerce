package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.Cart;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.AddItemRequest;
import com.aditya.ecommerce.application.response.ApiResponse;
import com.aditya.ecommerce.application.service.CartService;
import com.aditya.ecommerce.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest request,@RequestHeader("Authorization") String jwt)throws UserException, ProductException{
        User user = userService.findUserProfileByJwt(jwt);

        cartService.addCartItem(user.getId(),request);

        ApiResponse response = new ApiResponse();
        response.setMessage("Item added to cart.");
        response.setStatus(true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
