package com.boii.backendecommerce.service.productServices;


import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.repository.CategoryRepository;
import com.boii.backendecommerce.repository.ProductRepository;
import com.boii.backendecommerce.repository.projections.ProductProjection;
import com.boii.backendecommerce.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("RealProductService")
public class RealProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;


    // Injecting Dependencies
    @Autowired
    public RealProductService(ProductRepository productRepository,
                              CategoryService categoryService,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
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

    @Override
    public List<Product> findProductsByTitle(String searchText) {
        return productRepository.findProductsByTitleContaining(searchText);
    }

//    Representing Inheritance, Cardinalities, IDs, JPA Queries, Custom Queries 1.15


    @Override
    public Product getProductByIdAndTitle(Long id)
            throws ProductNotFoundException {
        Product product = productRepository.getProductFromIdAndTitle(id);
        ProductProjection productProjection = productRepository.getTitleAndPriceProductFromId(id);
        return product;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {

        // findAll(Pageable pageable);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        // this will return me page<t> where T is Model
        Page<Product> productPage = productRepository.findAll(pageable);
        productPage.getTotalPages();
        productPage.getContent();
        productPage.getTotalElements();
        return productPage;
    }


}

