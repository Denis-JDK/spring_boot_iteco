package com.iteco.spring_boot_iteco.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
}
