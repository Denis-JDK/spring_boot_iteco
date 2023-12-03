package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.BankBookDto;
import com.iteco.spring_boot_iteco.service.BankBookService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/bank-book/")
public class BankBookController {

    private final BankBookService bankBookService;


    public BankBookController(BankBookService bankBookService) {
        this.bankBookService = bankBookService;
    }
    @GetMapping({"/by-user-id/{id}", "/"})
    public ResponseEntity<List<BankBookDto>> getBankBookById(@PathVariable Integer id){
        return ResponseEntity.ok(Collections.singletonList(bankBookService.findById(id)));
    }

    @GetMapping("/by-user-id/{userId}")
    public ResponseEntity<List<BankBookDto>> getBankBookByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }
    @PostMapping
    @SneakyThrows
    public ResponseEntity<BankBookDto> createBankBook(@RequestBody BankBookDto bankBookDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankBookService.create(bankBookDto));
    }
    @PutMapping
    @SneakyThrows
    public BankBookDto updateBankBook(@RequestBody BankBookDto bankBookDto){
        return bankBookService.update(bankBookDto);
    }
    @DeleteMapping({"/{id}", "/"})
    public void deleteBankBook(@PathVariable Integer id){
        bankBookService.delete(id);
    }
    @DeleteMapping({"/by-user-id/{id}", "/by-user-id/"})
    public void deleteBankBookByUserId(@PathVariable Integer id){
        bankBookService.deleteByUserId(id);
    }

}