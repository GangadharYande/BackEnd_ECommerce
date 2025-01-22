package com.boii.backendecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String tittle;
    private Double price;
    private String description;
    private String imageURL;

    private Category category;


}
