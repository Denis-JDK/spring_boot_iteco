package com.iteco.spring_boot_iteco.model;

import org.springframework.stereotype.Component;

@Component
public class BankBook {
    private long number;
    private Integer id;
    public void setNumber(long l) {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankBook{" +
                "number=" + number +
                ", id=" + id +
                '}';
    }
}
