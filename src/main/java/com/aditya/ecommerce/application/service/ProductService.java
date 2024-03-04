package com.aditya.ecommerce.application.service;

import com.aditya.ecommerce.application.model.Product;
import com.aditya.ecommerce.application.request.CreateProductRequest;

public interface ProductService {


     Product createProduct(CreateProductRequest request);
}
