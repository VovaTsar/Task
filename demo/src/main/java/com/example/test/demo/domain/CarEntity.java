package com.example.test.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarEntity {

    private Long id;
    private String model;
}
