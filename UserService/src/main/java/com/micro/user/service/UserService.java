package com.micro.user.service;

import com.micro.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(String userId);

    UserDto deleteUserById(String userId);

}
