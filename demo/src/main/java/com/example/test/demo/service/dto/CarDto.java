package com.example.test.demo.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarDto {

    private Long id;
    private String model;
}
