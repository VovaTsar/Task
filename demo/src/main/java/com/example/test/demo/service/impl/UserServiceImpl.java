package com.example.test.demo.service.impl;

import com.example.test.demo.domain.UserEntity;
import com.example.test.demo.repository.VirtualRepoDb;
import com.example.test.demo.service.UserService;
import com.example.test.demo.service.dto.UserDto;
import com.example.test.demo.service.exception.SearchRuntimeException;
import com.example.test.demo.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final VirtualRepoDb virtualRepoDb;
    private final UserMapper userMapper;


    @Override
    public UserDto createUser(UserEntity userEntity) {
        log.debug("Request to create User");
        var userById = virtualRepoDb.getUserById(userEntity.getId());
        if (userById.isPresent()) {
            throw new SearchRuntimeException("User is already present");
        }

        var user = virtualRepoDb.createUser(userEntity);

        return userMapper.mapToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.debug("Request to get all users");
        var userEntities = virtualRepoDb.getAllUsers();

        return userMapper.mapToDto(userEntities);
    }

    @Override
    public UserDto getUserById(Long id) {
        log.debug("Request to get User by id: {}", id);
        var userEntity = virtualRepoDb.getUserById(id)
                .orElseThrow(() -> new SearchRuntimeException("Can not find user"));

        return userMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto updateUser(Long id, UserEntity user) {
        log.debug("Request to update User, id {}", user.getId());
        var userEntityToUpdate = virtualRepoDb.getUserById(id)
                .orElseThrow(() -> new SearchRuntimeException("Can not find user"));
        var userEntity = virtualRepoDb.updateUser(userEntityToUpdate, user);

        return userMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto deleteUserById(Long id) {
        log.debug("Request to delete User by id {}", id);
        var userEntityToDelete = virtualRepoDb.getUserById(id)
                .orElseThrow(() -> new SearchRuntimeException("Can not find user"));

        var userEntity = virtualRepoDb.deleteUserById(userEntityToDelete);

        return userMapper.mapToDto(userEntity);
    }
}
