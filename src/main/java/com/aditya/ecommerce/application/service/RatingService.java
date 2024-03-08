package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Rating;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.request.RatingRequest;

import java.util.List;

public interface RatingService {
    Rating createRating(RatingRequest request, User user) throws ProductException;
    List<Rating> getProductsRating(Long productId);


}
