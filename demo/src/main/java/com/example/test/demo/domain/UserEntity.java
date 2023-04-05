package com.example.test.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Builder
public class UserEntity {

    private Long id;
    private String name;
    private List<CarEntity> cars;
}
