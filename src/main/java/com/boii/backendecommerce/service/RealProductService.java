package com.boii.backendecommerce.service;

import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("RealProductService")
public class RealProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    // Injecting Dependencies
    @Autowired
    public RealProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }



    @Override
    public Product createProduct(String title, String description, String category, String price, String imageUrl) {
        // Find Category by Title, if not found create a new category
        Category categoryObj = categoryService.findByTitle(category);
        System.out.println("Category is created "+categoryObj);
        // Create new Product
        Product newProduct = new Product();
        newProduct.setTitle(title);
        newProduct.setDescription(description);
        newProduct.setCategory(categoryObj);
        newProduct.setPrice(Double.parseDouble(price));
        newProduct.setImageURL(imageUrl);

        newProduct.setCreatedAt(new Date());
        newProduct.setLastUpdatedAt(newProduct.getCreatedAt());
        newProduct.set_Deleted(false);

        Product returnedProduct = productRepository.save(newProduct);
        System.out.println("Product is created  in Database" + returnedProduct);
        return returnedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}

