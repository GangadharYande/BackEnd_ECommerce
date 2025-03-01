package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.builder.ProductMapper;
import com.boii.backendecommerce.dto.CreateProductRequestDto;
import com.boii.backendecommerce.dto.RealProductResponseDto;
import com.boii.backendecommerce.exceptions.InvalidProductIdException;
import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.repository.ProductRepository;
import com.boii.backendecommerce.service.category.CategoryService;
import com.boii.backendecommerce.service.productServices.ProductService;
import com.boii.backendecommerce.service.productServices.RealProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final ProductRepository productRepository;

    private final CategoryService categoryService;
    private final RealProductService realProductService;

    // Injecting ProductService in Controller
    public ProductController(@Qualifier("RealProductService")
                                                          ProductService productService,
                                                          ProductRepository productRepository,
                                                          CategoryService categoryService, RealProductService realProductService) {
//    public ProductController(@Qualifier("FakeStoreService")
//                             ProductService productService,
//                             ProductRepository productRepository,
//                             CategoryService categoryService, RealProductService realProductService) {

        this.productService = productService;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.realProductService = realProductService;
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
    public RealProductResponseDto createProduct(@RequestBody CreateProductRequestDto dto) {
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
    public List<RealProductResponseDto> getAllProducts() throws ProductNotFoundException {
        List<Product> productList = productService.getAllProducts();
        if (productList.isEmpty() || productList.size() == 0) {
            throw new ProductNotFoundException();
        }

        List<RealProductResponseDto> response = new ArrayList<>();
        for (Product p : productList) {
            response.add(ProductMapper.convertToProductResponseDto(p));
        }

        return response;


    }


    // Get a single product
    @GetMapping("/product/{id}")
    public RealProductResponseDto getProductByID(@PathVariable("id") Long id) throws
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

    @GetMapping("/product/{id}/{title}")
    public Product getProductByIdAndTitle(@PathVariable("id") Long id, @RequestParam String title) throws ProductNotFoundException {
        if (id == null) {
            throw new ProductNotFoundException();
        }
        return productRepository.getProductByIdAndTitle(id, title);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String searchText) {
        List<Product> products = productService.findProductsByTitle(searchText);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/products/{page}/{size}")
    public ResponseEntity<Page<Product>> getPaginationProducts(@PathVariable("page") Integer pageNo,
                                                               @PathVariable("size") Integer pageSize) {


        Page<Product> ListedProduct =productService.getPaginatedProducts(pageNo, pageSize);
        System.out.println("Received products " + ListedProduct);
        return  ResponseEntity.ok(ListedProduct); // Status Http =ok
    }


    @GetMapping("/products/sortbyName/{pageNo}/{pageSize}")
    public ResponseEntity<Page<Product>> getPagedProductSortByName(@PathVariable("pageNo") Integer pageNo,
                                                                   @PathVariable("pageSize") Integer pageSize){
        Page<Product> ListedProduct =productService.getPaginatedProducts(pageNo, pageSize);
        System.out.println("Received products " + ListedProduct);
        return  ResponseEntity.ok(ListedProduct); // Status Http =ok

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) throws ProductNotFoundException {

        Product product = productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @DeleteMapping("/product/soft/{id}")
    public ResponseEntity<String> softDeleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.softDeleteProduct(id);
        return ResponseEntity.ok("Product marked as deleted");
    }

    @DeleteMapping("/product/hard/{id}")
    public ResponseEntity<String> harddeleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.hardDeleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
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
//
//
//
//
//
//
//
//
//
//
//    //Delete a product
//    @DeleteMapping("/product/{id}")
//    public void deleteProduct(@PathVariable("id") Long id){
//
//    }

}
