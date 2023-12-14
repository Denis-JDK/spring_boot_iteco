package com.iteco.spring_boot_iteco.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    @Null//(groups = Create.class) todo урок валидация
    @NotNull//(groups = Update.class)
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;

    private AddressDto addressDto;
}
