package com.boii.backendecommerce.service;


import com.boii.backendecommerce.dto.FakeStoreProductResponseDto;
import com.boii.backendecommerce.model.Category;
import com.boii.backendecommerce.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;




/* @Service @RestController @Bean  @Repository @Component @Controller
* all  have same Functionalities this annotation with interact with spring to create objects
* */

/*
 call from another server is Http
 the easiest way to use @RestTemplate (spring web dependency)
 */
@Service // telling spring this class is special class (all special class in spring are called bean)
public class FakeStoreService implements  ProductService{


    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate, StandardServletMultipartResolver standardServletMultipartResolver) { // No bean Error so created appConfig class and @Bean added
        this.restTemplate = restTemplate;

    }

    @Override
    public Product getProductById(Long id) {

        // 1. call the fake store API
        ResponseEntity<FakeStoreProductResponseDto> response = restTemplate.
                getForEntity("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductResponseDto.class); //FakeStoreResponseDTO


        // validations
        if (response.getBody() == null) {
            // Throw The exception
            System.out.println("Product body is null");
        }

        // 2. get the body form the response entity
        FakeStoreProductResponseDto fakeStoreProductResponseDto = response.getBody();

        /* 3. Map the response to our model
                4. return the model from service layer
                5. return type of service layer will be Model or DTO
                   if in case of Model  we can do Model to DTO Conversion in controller
                  service layer actually (Check productController)
        */
        return mapToProduct(fakeStoreProductResponseDto);
    }

    private Product mapToProduct(FakeStoreProductResponseDto dto) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(dto.getCategory());

        product.setCategory(category);
        product.setTittle(dto.getTitle());
        product.setId(dto.getId());
        product.setImageURL(dto.getImage());
        product.setPrice(Double.valueOf(dto.getPrice()));
        product.setDescription(dto.getDescription());
        return product;
    }

    @Override
    public void createProduct() {

    }
}
