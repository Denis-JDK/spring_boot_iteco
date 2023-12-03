package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.ExternalInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExternalServiceImpl implements ExternalService{
    @Override
    public ExternalInfo getInfo() {
        log.info("Call get info");
        return ExternalInfo.builder().info("INFO!").build();
    }

    @Override
    public ExternalInfo getHello() {
        log.info("Call getHello of ExternalServiceImpl");
        return ExternalInfo.builder().info("HELLO").build();
    }
}
