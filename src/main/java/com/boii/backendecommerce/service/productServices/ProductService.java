package com.boii.backendecommerce.service.productServices;

// this will only have function declaration . not the body

import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
   public Product getProductById(Long id) throws ProductNotFoundException;

    public Product createProduct(String title,
                          String description,
                          String category,
                          String price,
                          String imageUrl);





    public List<Product> getAllProducts();

    public List<Product> findProductsByTitle(String searchText);

    public Product updateProduct(Long id, Product product) throws ProductNotFoundException;

    public void softDeleteProduct(Long id) throws ProductNotFoundException;

    public void hardDeleteProduct(Long id) throws ProductNotFoundException;

    public Product getProductByIdAndTitle(Long id)
            throws ProductNotFoundException;

    public List<Category> getAllCategories();

    public Page<Product> getPaginatedProducts(int pageNo, int pageSize);

    public Page<Product> getPagedProductSortByName(int pageNo ,int pageSize);


}

