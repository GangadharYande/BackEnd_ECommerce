package com.boii.backendecommerce.service.Users;

import com.boii.backendecommerce.dto.UserDto;
import com.boii.backendecommerce.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImp implements UserServices{
    @Override
    public List<UserDto> getAllUsers() {
        String url = "https://fakestoreapi.com/users";
        RestTemplate restTemplate = new RestTemplate();

        // Fetch data and map to UserDto[]
        UserDto[] usersArray = restTemplate.getForObject(url, UserDto[].class);

        if (usersArray == null) {
            return List.of(); // Return empty list if no data
        }

        return Arrays.asList(usersArray); // Convert array to List and return
    }


    @Override
    public UserDto getUserById(Long id) {
        String url = "https://fakestoreapi.com/users/" + id;
        RestTemplate restTemplate = new RestTemplate();
        UserDto user = restTemplate.getForObject(url, UserDto.class);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        String url = "https://fakestoreapi.com/users";
        RestTemplate restTemplate = new RestTemplate();

        // Log the request payload
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestPayload = objectMapper.writeValueAsString(userDto);
            System.out.println("Request Payload: " + requestPayload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpEntity<UserDto> request = new HttpEntity<>(userDto);
        System.out.println("Sending Request: " + userDto); // Debugging
        ResponseEntity<UserDto> response = restTemplate.postForEntity(url, request, UserDto.class);
        System.out.println("Response: " + response.getBody()); // Debugging
        return response.getBody();
    }





    @Override
    public UserDto updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
