package com.iteco.spring_boot_iteco.model.exception;

public class BankBookNumberCannotBeModifiedException extends Throwable {
    public BankBookNumberCannotBeModifiedException(String s) {
        System.out.println(s);
    }
}
