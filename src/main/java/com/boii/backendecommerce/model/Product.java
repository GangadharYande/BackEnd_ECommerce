package com.boii.backendecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity // telling spring to create table annotation
@NoArgsConstructor
public class Product extends BaseModel implements Serializable {


    private String title;
    private Double price;
    private String description;
    private String imageURL;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
