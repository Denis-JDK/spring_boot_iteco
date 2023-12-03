package com.iteco.spring_boot_iteco.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@Data
@Builder
public class BankBookDto {
    private Integer id;
    private Integer userId;
    private String number;
    private BigDecimal amount;
    private String currency;
}
