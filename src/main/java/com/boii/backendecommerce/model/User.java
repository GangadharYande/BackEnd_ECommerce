package com.boii.backendecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddress> userAddresses;
}
