package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.BankBookDto;
import com.iteco.spring_boot_iteco.service.BankBookService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/rest/bank-book/")
public class BankBookController {

    private final BankBookService bankBookService;


    public BankBookController(BankBookService bankBookService) {
        this.bankBookService = bankBookService;
    }

    @GetMapping({"/{id}", "/"})
    public ResponseEntity<BankBookDto> getBankBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bankBookService.findById(id));
    }

    @GetMapping("/by-user-id")
    public ResponseEntity<List<BankBookDto>> getBankBookByUserId(@CookieValue Integer userId) { //в postman отправляем запрос с заголовком Headers: Key=Cookie Value=userId=1; Max-Age=600; Expires=Thu, 07 Dec 2023 15:01:24 GMT и аннотация @CookieValue принимает и подставляет параметр и далее отрабатывает метод поиска с входящим в куках параметром
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }

    @GetMapping("/header/by-user-id")
    public ResponseEntity<List<BankBookDto>> getBankBookByUserIdTestSpringHeader(@CookieValue Integer userId, @RequestHeader Map<String, String> headers) {
        log.info("Call with headers: {}" + headers);  //http://localhost:8090/rest/bank-book/header/by-user-id  получаем трассировку @RequestHeader("Trace-Id") Integer traceId, трассировка нужна чтоб в микросервисной архитектуре проследить сколько сервисов было задействовано при запросе от клиента
        return ResponseEntity.ok(bankBookService.findByUserId(userId));
    }

    @PostMapping
    @SneakyThrows
    public ResponseEntity<BankBookDto> createBankBook(@Valid @RequestBody BankBookDto bankBookDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankBookService.create(bankBookDto));
    }

    @PutMapping
    @SneakyThrows
    public BankBookDto updateBankBook(@RequestBody BankBookDto bankBookDto) {
        return bankBookService.update(bankBookDto);
    }

    @DeleteMapping({"/{id}", "/"})
    public void deleteBankBook(@PathVariable Integer id) {
        bankBookService.delete(id);
    }

    @DeleteMapping({"/by-user-id/{id}", "/by-user-id/"})
    public void deleteBankBookByUserId(@PathVariable Integer id) {
        bankBookService.deleteByUserId(id);
    }


}
