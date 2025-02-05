package com.boii.backendecommerce.service;

import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category findByTitle(String title) {
        Category existingCategory = categoryRepository.findByTitle(title);
        if (existingCategory == null) {
            existingCategory = new Category();
            existingCategory.setTitle(title);
            existingCategory.setCreatedAt(new Date());
            existingCategory.setLastUpdatedAt(existingCategory.getCreatedAt());
            existingCategory.set_Deleted(false);

            existingCategory = categoryRepository.save(existingCategory);
        }
        return existingCategory;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories(){
        String url="https://fakestoreapi.com/products/categories";

        RestTemplate restTemplate = new RestTemplate();
        List<String> categories = restTemplate.getForObject(url, List.class);

        List<CategoryResponseDto> categoryResponseList = new ArrayList<>();

        for(String category : categories){
            CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
            categoryResponseDto.setTitle(category);
            categoryResponseList.add(categoryResponseDto);
        }
        return categoryResponseList;
    }

}

