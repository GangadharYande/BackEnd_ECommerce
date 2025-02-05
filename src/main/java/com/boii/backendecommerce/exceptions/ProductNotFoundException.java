package com.boii.backendecommerce.exceptions;

public class ProductNotFoundException extends Throwable {

    public ProductNotFoundException() {

    }
    public ProductNotFoundException(String message) {

        super(message);
    }

}
