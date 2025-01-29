package com.boii.backendecommerce.repository.projections;

public interface ProductProjection {
    Long getId();
    String getTitle();
    Double getPrice();
    String getDescription();

}
