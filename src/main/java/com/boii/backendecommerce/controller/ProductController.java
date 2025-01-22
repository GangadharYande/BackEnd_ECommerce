package com.boii.backendecommerce.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
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
