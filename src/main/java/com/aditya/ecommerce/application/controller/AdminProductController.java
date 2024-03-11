package com.aditya.ecommerce.application.controller;

import com.aditya.ecommerce.application.exception.ProductException;
import com.aditya.ecommerce.application.model.Product;
import com.aditya.ecommerce.application.request.CreateProductRequest;
import com.aditya.ecommerce.application.response.ApiResponse;
import com.aditya.ecommerce.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/products")
public class AdminProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(request);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Product deleted sucessfully");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product request, @PathVariable Long productId) throws ProductException {
        Product product = productService.updateProduct(productId, request);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] request){
        for (CreateProductRequest product: request){
            productService.createProduct(product);
        }
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Product delated sucessfully");
        apiResponse.setStatus(true);
        return  new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
    }

}
