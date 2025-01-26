package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.builder.ProductMapper;
import com.boii.backendecommerce.dto.CreateProductRequestDto;
import com.boii.backendecommerce.dto.ProductResponseDto;
import com.boii.backendecommerce.exceptions.InvalidProductIdException;
import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    /*  Responsibilities
        1. Get the Request
        2. validate the request
        3. call the service layer
        4. get response from service layer
        5. convert response if needed
        6. return to client or customer


    */


    // This is Dependency Injection (Injecting ProductService in Controller)
    private final ProductService productService;


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


    // Create a Product
    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody CreateProductRequestDto dto) {
        // S1 validate the request --check and add validation of your own


        // S2 Create a product
        Product productResp = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getImage());

        // Convert this to Dto (need to implement)
        // below is just for testing
        return ProductMapper.convertToProductResponseDto(productResp);
    }


    // Get all products
    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() throws ProductNotFoundException {
        List<Product> productList = productService.getAllProducts();
        if (productList.isEmpty() || productList.size() == 0) {
            throw new ProductNotFoundException();
        }

        List<ProductResponseDto> response = new ArrayList<>();
        for (Product p : productList) {
            response.add(ProductMapper.convertToProductResponseDto(p));
        }

        return response;


    }


    // Get a single product
    @GetMapping("/product/{id}")
    public ProductResponseDto getProductByID(@PathVariable("id") Long id) throws
            InvalidProductIdException, ProductNotFoundException {


        if (id == null) {
            throw new InvalidProductIdException();
        }


        // S1. Call to service layer
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException();
        }

        // S2. Convert(map) model to DTO
        // S3. return
        return ProductMapper.convertToProductResponseDto(product);

    }






    /* Implement below methods */

//    //Limit results "https://fakestoreapi.com/products?limit=5"
//    @GetMapping("/products/{limit}")
//    public List<Product> getProductsInLimit(Long limit) {
//        return null;
//    }
//
//
//    // Sort results https://fakestoreapi.com/products?sort=desc
//    @GetMapping("/product/sorted")
//    public ResponseEntity<List<Product>> getSortedProducts() {
//        /*
//            List<Product> products = productService.fetchAndSortProducts();
//            return new ResponseEntity<>(products, HttpStatus.OK);
//       */
//        return null;
//    }
//
//
//    // Get all categories
//    @GetMapping("categories")
//    public ResponseEntity<List<String>> getAllCategories() {
//        /*
//            List<String> categories = productService.fetchCategories();
//            return new ResponseEntity<>(categories, HttpStatus.OK);
//        */
//
//        return null;
//    }
//
//
//    // Get products in a specific category
//    @GetMapping("/category/{category}")
//    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
//        /*
//        List<Product> products = productService.fetchProductsByCategory(category);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//        */
//        return null;
//    }
//
//
//    //Update a product
//    @PutMapping("/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
//        /*
//        Product product = productService.updateProduct(id, updatedProduct);
//        return new ResponseEntity<>(product, HttpStatus.OK);
//
//         */
//        return null;
//    }
//
//
//    //Delete a product
//    @DeleteMapping("/product/{id}")
//    public void deleteProduct(@PathVariable("id") Long id){
//
//    }


}
