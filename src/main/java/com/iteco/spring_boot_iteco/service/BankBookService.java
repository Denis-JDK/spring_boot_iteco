package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.BankBook;

import java.util.List;

public interface BankBookService {
    List<BankBook> getBankBooksById(Integer id);
}
