package com.example.test.demo.service.mapper;

import com.example.test.demo.domain.UserEntity;
import com.example.test.demo.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapToDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .cars(userEntity.getCars())
                .build();
    }

    public List<UserDto> mapToDto(List<UserEntity> userEntity) {
        return userEntity.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public UserEntity mapToEntity(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .cars(userDto.getCars())
                .build();
    }

}
