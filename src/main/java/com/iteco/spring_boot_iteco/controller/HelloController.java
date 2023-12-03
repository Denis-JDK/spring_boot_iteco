package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.ExternalInfo;
import com.iteco.spring_boot_iteco.service.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getHello(@RequestParam(defaultValue = "Default Value") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
}
