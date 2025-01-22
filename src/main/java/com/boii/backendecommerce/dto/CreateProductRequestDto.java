package com.boii.backendecommerce.dto;

import com.boii.backendecommerce.model.Category;

public class CreateProductRequestDto {
    private int id;
    private String tittle;
    private Double price;
    private String description;
    private String imageURL;

    private Category category;
}
