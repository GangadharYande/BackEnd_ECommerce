package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.exceptions.NoCategoryFoundException;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.repository.ProductRepository;
import com.boii.backendecommerce.service.CategoryService;
import com.boii.backendecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {



    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public CategoryController(@Qualifier("FakeStoreService")
                              ProductService productService,
                              ProductRepository productRepository,
                              CategoryService categoryService) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories() throws NoCategoryFoundException {
        return categoryService.getAllCategories();

    }
}
