package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.ExternalInfo;
import com.iteco.spring_boot_iteco.service.ExternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    private final ExternalService externalService;

    DefaultController(ExternalService externalService) {
        this.externalService = externalService;
    }
    @GetMapping("/info")
    ExternalInfo getInfo(){
        return externalService.getInfo();
    }
    @GetMapping("/hi")
    public ExternalInfo getHello(){
        return externalService.getHello();
    }
}
