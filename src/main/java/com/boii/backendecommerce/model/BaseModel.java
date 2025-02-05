package com.boii.backendecommerce.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean is_Deleted = false;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        lastUpdatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdatedAt = new Date();
    }
}
