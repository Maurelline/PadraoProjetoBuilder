package com.builderpattern.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pessoa {

    private String firstName;
    private String lastName;
    private Integer age;
    private Integer height;
}
