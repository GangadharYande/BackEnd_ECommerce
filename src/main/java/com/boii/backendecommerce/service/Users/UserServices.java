package com.boii.backendecommerce.service.Users;

import com.boii.backendecommerce.dto.UserDto;
import com.boii.backendecommerce.model.User;

import java.util.List;

public interface UserServices {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(User user);
    void deleteUser(Long id);

}
