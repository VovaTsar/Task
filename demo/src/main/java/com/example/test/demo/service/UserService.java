package com.example.test.demo.service;

import com.example.test.demo.domain.UserEntity;
import com.example.test.demo.service.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserEntity user);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserEntity user);

    UserDto deleteUserById(Long id);
}
