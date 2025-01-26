package com.boii.backendecommerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;


}
