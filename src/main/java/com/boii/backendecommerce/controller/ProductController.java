package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.dto.ProductResponseDTO;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.service.ProductService;
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


    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductByID(@PathVariable("id") Long id) {
        validationRequestParam(id);

        // S1. Call to service layer
        Product product = productService.getProductById(id);

        // S2. Convert(map) model to DTO

        // S3. return
        return convertToProductResponseDTO(product);

    }

    private void validationRequestParam(Long id) {
        // Validations
        if (id == null) {
            // thorw exceptions
        }
    }

    private ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setTittle(product.getTittle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());


        return dto;
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
}
