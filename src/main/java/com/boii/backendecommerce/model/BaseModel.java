package com.boii.backendecommerce.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass // The following attribute will be used in child models
@NoArgsConstructor
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // AutoIncrement
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean is_Deleted;
}
