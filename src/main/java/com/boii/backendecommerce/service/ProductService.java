package com.boii.backendecommerce.service;

// this will only have function declaration . not the body

import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;

    Product createProduct(String title,
                          String description,
                          String category,
                          String price,
                          String imageUrl);





    List<Product> getAllProducts();
}

