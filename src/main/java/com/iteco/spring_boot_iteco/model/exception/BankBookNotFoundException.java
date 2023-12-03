package com.iteco.spring_boot_iteco.model.exception;

public class BankBookNotFoundException extends Throwable {
    public BankBookNotFoundException(String s) {
        System.out.println(s);
    }
}
