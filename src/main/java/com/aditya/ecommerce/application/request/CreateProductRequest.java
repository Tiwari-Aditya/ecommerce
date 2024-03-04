package com.aditya.ecommerce.application.request;

import com.aditya.ecommerce.application.model.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CreateProductRequest {
    private final Set<Size> size = new HashSet<>();
    private String title;
    private String description;
    private int price;
    private int discountedPrice;
    private int discountPercent;
    private int quantity;
    private String brand;
    private String color;
    private String imageUrl;
    private String topLevelCategory;
    private String secondLevelCategory;
    private String thirdLevelCategory;

}
