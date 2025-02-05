package com.boii.backendecommerce;

import com.boii.backendecommerce.repository.ProductRepository;
import com.boii.backendecommerce.repository.projections.ProductProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackEndEcommerceApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testingHQLQuery() {
        List<ProductProjection> pros = productRepository.getTitleAndPriceProductFromTitle("Samsung");
        if (!pros.isEmpty()) {
            System.out.println(pros.get(0).getPrice());
        } else {
            System.out.println("No products found with the title 'Samsung'");
        }
    }

}
