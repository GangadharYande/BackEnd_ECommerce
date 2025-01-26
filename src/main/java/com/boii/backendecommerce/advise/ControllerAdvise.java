package com.boii.backendecommerce.advise;

import com.boii.backendecommerce.dto.ErrorDto;
import com.boii.backendecommerce.exceptions.InvalidProductIdException;
import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        ErrorDto dto = new ErrorDto();
        dto.setErrorCode("404");
        dto.setMessage(exception.getMessage());


        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDto> handleInvalidProductIdException(InvalidProductIdException exception) {
        ErrorDto dto = new ErrorDto();
        dto.setErrorCode("404");
        dto.setMessage(exception.getMessage());


        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception) {
        ErrorDto dto = new ErrorDto();
        dto.setErrorCode("404");
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
