package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.PersonalInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService{
   @Value("${name}")
    private String name;

    public PersonalInformationServiceImpl(){
    }

    @PostConstruct
    public void init(){
        if (name.contains("N"))
            System.out.println("Contains 'N' ");
    }
    public PersonalInfo getPersonalInfo(Integer id){
        return null;
    }
}
