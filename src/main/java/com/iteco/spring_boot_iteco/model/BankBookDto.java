package com.iteco.spring_boot_iteco.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
@Data
@Builder
public class BankBookDto {
    @Null
    private Integer id;
    private Integer userId;
    @NotBlank
    private String number;
    @Min(value = 0l)
    private BigDecimal amount;
    private String currency;
}
