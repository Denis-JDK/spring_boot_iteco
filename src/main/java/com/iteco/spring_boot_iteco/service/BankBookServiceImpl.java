package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.BankBook;
import com.iteco.spring_boot_iteco.model.annotation.InjectRandom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BankBookServiceImpl {
    @InjectRandom(max= 100)
    private Integer number;

    public List<BankBook>getBankBooksById(Integer id){
        BankBook bankBook = new BankBook();
        bankBook.setNumber(1L);
        bankBook.setId(id);
        ArrayList<BankBook> bankBooks = new ArrayList<>();
        bankBooks.add(bankBook);

        return bankBooks;
    }
}
