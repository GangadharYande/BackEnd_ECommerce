package com.boii.backendecommerce.service;

// this will only have function declaration . not the body

import com.boii.backendecommerce.model.Product;

public interface ProductService {

    Product getProductById(Long id);
    void createProduct();
}
