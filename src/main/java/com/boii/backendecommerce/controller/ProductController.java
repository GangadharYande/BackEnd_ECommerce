package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.service.FakeStoreService;
import com.boii.backendecommerce.service.ProductService;
import com.boii.backendecommerce.service.RealProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    // This is Dependency Injection (Injecting ProductService in Controller)
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    /*
     * ProductController productService = new ProductController(productService);
     * this object will be created by Spring in back
     *
     * TOPOLOGICAL SORT
     * PRODUCTSERVICE -- PRODUCTCONTROLLER
     * */

    @PostMapping("/product")
    public void createProduct() {

    }

    @GetMapping("/products")
    public void getAllProducts() {

    }
    /*

     */

    @GetMapping("/product/{id}")
    public void getProductByID(@PathVariable("id") Long id) {

    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
