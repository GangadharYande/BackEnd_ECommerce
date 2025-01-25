package com.boii.backendecommerce.builder;

import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.dto.ProductResponseDto;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;

public class ProductMapper {
    /*
      Converts the incoming Object to ProductResponseDTO
      @param product
      @return
    */
    public static ProductResponseDto convertToProductResponseDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setTittle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());

        if(product.getId()!=null){
            dto.setId(product.getId());
        }

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
        product.setPrice(Double.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }
}
