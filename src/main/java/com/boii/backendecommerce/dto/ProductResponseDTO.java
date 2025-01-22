package com.boii.backendecommerce.dto;

import com.boii.backendecommerce.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private int id;
    private String tittle;
    private Double price;
    private String description;
    private String imageURL;

    private Category category;
}
