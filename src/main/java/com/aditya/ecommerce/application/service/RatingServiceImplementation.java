package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Product;
import com.aditya.ecommerce.application.model.Rating;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.repository.RatingRepository;
import com.aditya.ecommerce.application.request.RatingRequest;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class RatingServiceImplementation implements RatingService {
    private final RatingRepository ratingRepository;
    private final ProductService productService;

    @Override
    public Rating createRating(RatingRequest request, User user) throws ProductException {
        Product product = productService.findProductById(request.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(request.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {

        return ratingRepository.getAllProductsRating(productId);
    }
}
