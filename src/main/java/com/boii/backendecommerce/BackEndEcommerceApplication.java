package com.boii.backendecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackEndEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndEcommerceApplication.class, args);
    }

}
