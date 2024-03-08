package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Product;
import com.aditya.ecommerce.application.model.Review;
import com.aditya.ecommerce.application.model.User;
import com.aditya.ecommerce.application.repository.ProductRepository;
import com.aditya.ecommerce.application.repository.ReviewRepository;
import com.aditya.ecommerce.application.request.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Override
    public Review createReview(ReviewRequest request, User user) throws ProductException {

        Product product = productService.findProductById(request.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(request.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
