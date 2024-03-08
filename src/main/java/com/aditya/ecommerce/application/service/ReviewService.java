package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Review;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    Review createReview(ReviewRequest request, User user)throws ProductException;
    List<Review> getAllReview(Long productId);
}
