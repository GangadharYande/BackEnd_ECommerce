package com.boii.backendecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel implements Serializable {


    private String title;


    @JsonIgnore
    @OneToMany(mappedBy = "category",cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    List<Product> product;

    /*
       CASCADE EFFECTS
       1. Don't Allow Category to be Deleted
       2. In product ,Make the category_id as null
       3. upon deleting Category ,delete Product also which are related
       4. Only FK mapping should have the constraints

    */



}
