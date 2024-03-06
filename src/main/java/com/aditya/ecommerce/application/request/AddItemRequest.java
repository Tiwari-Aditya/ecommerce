package com.aditya.ecommerce.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddItemRequest {
    private Long productId;
    private String size;
    private int quantiy;
    private Integer price;

}
