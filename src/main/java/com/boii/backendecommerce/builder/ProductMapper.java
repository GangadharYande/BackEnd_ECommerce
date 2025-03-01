package com.boii.backendecommerce.builder;

import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.dto.RealProductResponseDto;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;

public class ProductMapper {
    /*
      Converts the incoming Object to ProductResponseDTO
      @param product
      @return
    */
    public static RealProductResponseDto convertToProductResponseDto(Product product) {
        RealProductResponseDto dto = new RealProductResponseDto();
        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setTittle(product.getTitle());
        dto.setPrice(String.valueOf(product.getPrice()));
        dto.setDescription(product.getDescription());

        dto.setId(product.getId());

        return dto;
    }

    public static Product mapToProduct(FakeStoreProductDto dto) {



        Product product = new Product();
        Category category = new Category();
        category.setTitle(dto.getCategory());

        product.setCategory(category);
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(Double.valueOf(String.valueOf(dto.getPrice())));
        product.setDescription(dto.getDescription());
        return product;
    }


}
