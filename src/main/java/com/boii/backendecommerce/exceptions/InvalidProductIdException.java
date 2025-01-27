package com.boii.backendecommerce.exceptions;

public class InvalidProductIdException extends Throwable {
    public InvalidProductIdException() {
    }
    public InvalidProductIdException(String message) {
        super(message);
    }

}
