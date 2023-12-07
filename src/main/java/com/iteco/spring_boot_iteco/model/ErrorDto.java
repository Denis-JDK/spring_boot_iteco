package com.iteco.spring_boot_iteco.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDto {

    private String status;
    private String message;
}
