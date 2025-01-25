package com.boii.backendecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String imageURL;

    private Category category;


}
