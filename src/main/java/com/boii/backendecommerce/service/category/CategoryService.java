package com.boii.backendecommerce.service.category;

import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.model.Category;

import java.util.List;

public interface CategoryService  {

    Category findByTitle(String Title);
    List<CategoryResponseDto> getAllCategories();
    List<FakeStoreProductDto> getProductsByCategory(String category);
}
