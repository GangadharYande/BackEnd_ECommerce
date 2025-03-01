package com.boii.backendecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)  // To check if Jackson is even attempting to serialize properly
public class UserDto {
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;
    private String gender;


    @Setter
    @Getter
    public static class Name {
        private String firstname;
        private String lastname;


    }

    @Getter
    @Setter
    public static class Address {
        private String city;
        private String street;
        private int number;
        private String zipcode;
        private Geolocation geolocation;

        // Getters and Setters
        @Getter
        @Setter
        public static   class Geolocation {
            private Double lat;
            private Double Long;

            // Getters and Setters
        }
    }
}
