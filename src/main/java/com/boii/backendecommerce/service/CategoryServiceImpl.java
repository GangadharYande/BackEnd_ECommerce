package com.boii.backendecommerce.service;

import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

}

