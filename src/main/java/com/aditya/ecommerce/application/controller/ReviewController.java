package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.exception.UserException;
import com.aditya.ecommerce.application.model.Review;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.ReviewRequest;
import com.aditya.ecommerce.application.service.ReviewService;
import com.aditya.ecommerce.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest request, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Review review = reviewService.createReview(request, user);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId) throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReview(productId);
        return new ResponseEntity<>(reviews, HttpStatus.ACCEPTED);
    }
}
