package com.example.test.demo.service.dto;

import com.example.test.demo.domain.CarEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Builder
public class UserDto {

    private Long id;
    private String name;
    private List<CarEntity> cars;
}
