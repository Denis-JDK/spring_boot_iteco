package com.iteco.spring_boot_iteco.model.exception;

public class BankBookWithCurrencyAlreadyHaveException extends Throwable {
    public BankBookWithCurrencyAlreadyHaveException(String s) {
        System.out.println(s);;
    }
}
