package com.aditya.ecommerce.application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Street can not be blank")
    @Size(max = 255, message = "Street must be at most 255 characters")
    @Column(name = "street")
    private String street;

    @NotBlank(message = "City can not be blank")
    @Size(max = 100 ,message = "City must be at most 100 character")
    @Column()
    private String city;

    private String state;
    private String zipcode;


}
