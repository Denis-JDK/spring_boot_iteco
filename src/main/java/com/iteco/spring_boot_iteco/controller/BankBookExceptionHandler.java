package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.ErrorDto;
import com.iteco.spring_boot_iteco.model.exception.BankBookNotFoundException;
import com.iteco.spring_boot_iteco.model.exception.BankBookNumberCannotBeModifiedException;
import com.iteco.spring_boot_iteco.model.exception.BankBookWithCurrencyAlreadyHaveException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class BankBookExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND) //задаем код ошибки в ответе, без аннотации будет ошибка, но код отобразится 200
    @ExceptionHandler(BankBookNotFoundException.class)
    public ErrorDto handleBankBookNotFoundException(BankBookNotFoundException e) {
        log.error("ERROR!", e);
        return ErrorDto.builder()
                .status(HttpStatus.NOT_FOUND.name())
                .message(e.getMessage()) //берем сообщение из отловленного исключения в try/catch
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BankBookNumberCannotBeModifiedException.class)
    public ErrorDto handleBankBookNumberCannotBeModifiedException(BankBookNumberCannotBeModifiedException e) {
        log.error("ERROR!", e);
        return ErrorDto.builder()
                .status(HttpStatus.BAD_REQUEST.name())
                .message(e.getMessage())
                .build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorDto handleBankBookWithCurrencyAlreadyHaveException(BankBookWithCurrencyAlreadyHaveException e) {
        log.error("ERROR!", e);
        return ErrorDto.builder()
                .status(HttpStatus.BAD_REQUEST.name())
                .message(e.getMessage())
                .build();
    }
}
