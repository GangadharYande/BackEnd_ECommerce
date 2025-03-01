package com.boii.backendecommerce.service.category;

import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public List<CategoryResponseDto> getAllCategories() {
        String url = "https://fakestoreapi.com/products/categories";
        RestTemplate restTemplate = new RestTemplate();
        List<String> categories = restTemplate.getForObject(url, List.class);

        List<CategoryResponseDto> categoryDTOList = new ArrayList<>();
        for (String category : categories) {
            CategoryResponseDto categoryDTO = new CategoryResponseDto();
            categoryDTO.setTitle(category);
            categoryDTOList.add(categoryDTO);
        }

        return categoryDTOList;
    }


    @Override
    public List<FakeStoreProductDto> getProductsByCategory(String category) {
        String url = "https://fakestoreapi.com/products/category/" + category;
        RestTemplate restTemplate = new RestTemplate();
        List<FakeStoreProductDto> products = restTemplate.getForObject(url, List.class);

        List<FakeStoreProductDto> fakeStoreProductDtoList = new ArrayList<>();
        for(Object product : products){
            Map<String, Object> productMap = (Map<String, Object>) product;
            FakeStoreProductDto productDTO = new FakeStoreProductDto();
            productDTO.setId(((Number) productMap.get("id")).longValue());
            productDTO.setTitle((String) productMap.get("title"));
            productDTO.setPrice(String.valueOf(((Number) productMap.get("price")).doubleValue()));
            productDTO.setCategory((String) productMap.get("category"));
            productDTO.setDescription((String) productMap.get("description"));
            productDTO.setImage((String) productMap.get("image"));
            fakeStoreProductDtoList.add(productDTO);

        }
        return fakeStoreProductDtoList;
    }

}

