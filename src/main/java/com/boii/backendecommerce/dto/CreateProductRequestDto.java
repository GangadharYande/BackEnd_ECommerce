package com.boii.backendecommerce.dto;

import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {



    private  String title;
    private  String  price;
    private String category;
    private  String description;
    private  String image;




}
