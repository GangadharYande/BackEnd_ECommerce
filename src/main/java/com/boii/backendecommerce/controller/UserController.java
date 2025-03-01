package com.boii.backendecommerce.controller;

import com.boii.backendecommerce.dto.UserDto;
import com.boii.backendecommerce.service.Users.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserServices userServices;

    // Constructor-based Dependency Injection
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userServices.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/User/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        UserDto user = userServices.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/CreateUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userServices.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}
