package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.exceptions.NoCategoryFoundException;
import com.boii.backendecommerce.repository.ProductRepository;
import com.boii.backendecommerce.service.category.CategoryService;
import com.boii.backendecommerce.service.productServices.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {


    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public CategoryController(@Qualifier("FakeStoreService") //RealProductService or FakeStoreService
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

    @GetMapping("/category/{category}")
    public List<FakeStoreProductDto> getProductsByCategory(@PathVariable("category") String category)
            throws NoCategoryFoundException {
        return categoryService.getProductsByCategory(category);
    }
}
