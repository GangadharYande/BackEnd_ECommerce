package com.boii.backendecommerce.scheduleCronJobs;


import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.model.Product;
import com.boii.backendecommerce.service.productServices.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbFetcherPerMin {
    private ProductService productService;


    public DbFetcherPerMin(@Qualifier("RealProductService") ProductService productService) {
        this.productService = productService;
    }

//    @Scheduled(cron = "0 * * * * *")
//    public void DemoExecute() throws ProductNotFoundException {
//        Product product =productService.getProductById(1L);
//        System.out.println("Product for ID 1 "+product.getId());
//
//    }
}
