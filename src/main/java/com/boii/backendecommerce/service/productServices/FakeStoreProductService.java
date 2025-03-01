package com.boii.backendecommerce.service.productServices;


import com.boii.backendecommerce.builder.ProductMapper;
import com.boii.backendecommerce.dto.CategoryResponseDto;
import com.boii.backendecommerce.dto.FakeStoreProductDto;
import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.ArrayList;
import java.util.List;




/* @Service @RestController @Bean  @Repository @Component @Controller
* all  have same Functionalities this annotation with interact with spring to create objects
* */

/*
 call from another server is Http
 the easiest way to use @RestTemplate (spring web dependency)
 */
@Service("FakeStoreService") // telling spring this class is special class (all special class in spring are called bean)
public class FakeStoreProductService implements ProductService {


    private final RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, StandardServletMultipartResolver standardServletMultipartResolver) { // No bean Error so created appConfig class and @Bean added
        this.restTemplate = restTemplate;

    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        // 1. call the fake store API
        ResponseEntity<FakeStoreProductDto> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class); //FakeStoreResponseDTO


        // validations


        // 2. get the body form the response entity
        FakeStoreProductDto fakeStoreProductResponseDto = response.getBody();
        if(fakeStoreProductResponseDto == null) {
            throw new ProductNotFoundException();
        }

        /* 3. Map the response to our model
                4. return the model from service layer
                5. return type of service layer will be Model or DTO
                   if in case of Model  we can do Model to DTO Conversion in controller
                  service layer actually (Check productController)
        */
        return ProductMapper.mapToProduct(fakeStoreProductResponseDto);
    }

    @Override
    public Product createProduct(String title, String description, String category, String price, String imageUrl) {

        // S1. Call the fakeStore DTO object
        FakeStoreProductDto requestBody = new FakeStoreProductDto();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setCategory(category);
        requestBody.setPrice(String.valueOf(price));

        // S2. Call FakeStore API
        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreProductDto.class);

        // S3. Get ProductModel

        // S4.  ReturnModel

        return ProductMapper.mapToProduct(response);

    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        FakeStoreProductDto[] dtos = responseEntity.getBody();
        if(dtos == null||dtos.length == 0) {
            System.out.println("Something went wrong");
            return new ArrayList<>();
        }


        //Create products
        for(FakeStoreProductDto dto : dtos) {
            products.add(ProductMapper.mapToProduct(dto));
        }

        return products;
    }


    @Override
    public  List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        ResponseEntity<CategoryResponseDto> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                CategoryResponseDto.class);

        return categories;
    }

    @Override
    public Page<Product> getPaginatedProducts(int pageNo, int pageSize) {

        // Not Supported fakestore API Currently
        return null;
    }

    @Override
    public Page<Product> getPagedProductSortByName(int pageNo, int pageSize) {
        // Not Supported fakestore API Currently
        return null;
    }


    @Override
    public List<Product> findProductsByTitle(String searchText) {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public void softDeleteProduct(Long id) throws ProductNotFoundException {

    }

    @Override
    public void hardDeleteProduct(Long id) throws ProductNotFoundException {

    }

    @Override
    public Product getProductByIdAndTitle(Long id) throws ProductNotFoundException {
        return null;
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
