package com.boii.backendecommerce.dto;

import com.boii.backendecommerce.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealProductResponseDto {
    private Long id;
    private String tittle;
    private String price;
    private String description;
    private String imageURL;

    private Category category;
}
