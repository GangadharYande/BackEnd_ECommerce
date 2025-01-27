package com.boii.backendecommerce.repository;

import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product); // create

    List<Product> findAll();

    List<Product> findByCategory(Category category);

    Product findProductById(Long id);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByPriceLessThan(Double price);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}

