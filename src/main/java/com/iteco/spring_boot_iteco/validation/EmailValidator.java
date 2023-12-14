package com.iteco.spring_boot_iteco.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

    private static final String AT = "@";
    private static final String DOT = ".";


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.contains(AT) && s.contains(DOT);
    }
}
