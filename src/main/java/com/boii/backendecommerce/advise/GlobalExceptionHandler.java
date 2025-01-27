package com.boii.backendecommerce.advise;

import com.boii.backendecommerce.dto.ErrorDto;
import com.boii.backendecommerce.exceptions.InvalidProductIdException;
import com.boii.backendecommerce.exceptions.ProductNotFoundException;
import com.boii.backendecommerce.exceptions.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGeneralException(Exception exception) {
        return buildErrorResponse("500", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException exception) {
        return buildErrorResponse("500", "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException exception) {
        return buildErrorResponse("400", "Bad Request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        return buildErrorResponse("400", "Bad Request", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException exception) {
        return buildErrorResponse("400", "Validation Error", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ErrorDto> handleDataAccessException(DataAccessException exception) {
        return buildErrorResponse("500", "Database Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDto> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return buildErrorResponse("409", "Data Integrity Violation", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return buildErrorResponse("404", "Resource Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDto> handleInvalidProductIdException(InvalidProductIdException exception) {
        return buildErrorResponse("400", "Invalid Product ID", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception) {
        return buildErrorResponse("404", "Product Not Found", HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorDto> buildErrorResponse(String errorCode, String message, HttpStatus status) {
        ErrorDto dto = new ErrorDto(errorCode, message);
        return new ResponseEntity<>(dto, status);
    }
}
