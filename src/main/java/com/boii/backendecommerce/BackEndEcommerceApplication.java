package com.boii.backendecommerce;

import org.hibernate.annotations.Cache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class BackEndEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndEcommerceApplication.class, args);
    }

}
