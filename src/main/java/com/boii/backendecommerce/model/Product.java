package com.boii.backendecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String tittle;
    private String description;
    private Double price;
    private String imageURL;

    private Category category;
}
