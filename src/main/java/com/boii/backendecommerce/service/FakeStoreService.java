package com.boii.backendecommerce.service;


import org.springframework.stereotype.Service;




/* @Service @RestController @Bean  @Repository @Component @Controller
* all  have same Functionalities this annotation with interact with spring to create objects
* */
@Service // telling spring this class is special class (all special class in spring are called bean)
public class FakeStoreService implements  ProductService{


    @Override
    public void getProductById(Long id) {

    }

    @Override
    public void createProduct() {

    }
}
