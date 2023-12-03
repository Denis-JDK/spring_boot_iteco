package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.BankBookDto;
import com.iteco.spring_boot_iteco.model.exception.BankBookNotFoundException;
import com.iteco.spring_boot_iteco.model.exception.BankBookNumberCannotBeModifiedException;
import com.iteco.spring_boot_iteco.model.exception.BankBookWithCurrencyAlreadyHaveException;

import java.util.List;

public interface BankBookService {

    BankBookDto findById(Integer id);
    List<BankBookDto> findByUserId(Integer userId);

    BankBookDto create(BankBookDto bankBookDto) throws BankBookWithCurrencyAlreadyHaveException;

    BankBookDto update(BankBookDto bankBookDto) throws BankBookNotFoundException, BankBookNumberCannotBeModifiedException;
    void delete(Integer id);
    void deleteByUserId(Integer userId);


}
