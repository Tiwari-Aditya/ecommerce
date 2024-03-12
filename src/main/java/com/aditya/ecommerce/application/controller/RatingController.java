package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.Rating;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.RatingRequest;
import com.aditya.ecommerce.application.service.RatingService;
import com.aditya.ecommerce.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ratings")
public class RatingController {

    private final UserService userService;
    private final RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest request, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Rating rating = ratingService.createRating(request, user);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductRating(@PathVariable Long productId, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Rating> ratings = ratingService.getProductsRating(productId);
        return new ResponseEntity<>(ratings, HttpStatus.CREATED);
    }


}
