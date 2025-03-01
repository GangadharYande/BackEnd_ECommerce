package com.boii.backendecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserAddress extends BaseModel {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String geolocation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
