package com.boii.backendecommerce.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {


    private String message;
    private String errorCode;



    public ErrorDto() {

    }
}
