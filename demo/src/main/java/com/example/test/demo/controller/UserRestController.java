package com.example.test.demo.controller;

import com.example.test.demo.domain.UserEntity;
import com.example.test.demo.service.UserService;
import com.example.test.demo.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody UserEntity user) {
        log.info("Request to create User");
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Request to get all users");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        log.info("Request to get User by id: {}", id);
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        log.info("Request to update User, id {}", user.getId());
        return userService.updateUser(id, user);

    }

    @DeleteMapping("/{id}")
    public UserDto deleteUserById(@PathVariable Long id) {
        log.info("Request to delete User by id {}", id);
        return userService.deleteUserById(id);
    }

}
