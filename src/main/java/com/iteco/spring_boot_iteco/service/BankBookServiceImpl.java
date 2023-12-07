package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.BankBookDto;
import com.iteco.spring_boot_iteco.model.exception.BankBookNotFoundException;
import com.iteco.spring_boot_iteco.model.exception.BankBookNumberCannotBeModifiedException;
import com.iteco.spring_boot_iteco.model.exception.BankBookWithCurrencyAlreadyHaveException;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Service
public class BankBookServiceImpl implements BankBookService{
    private final Map<Integer, BankBookDto> bankBookDtoMap = new ConcurrentHashMap<>();
    private final AtomicInteger sequenceId = new AtomicInteger(1);

    @PostConstruct
    void init(){
        bankBookDtoMap.put(1, BankBookDto.builder()
                .id(1)
                .userId(1)
                .number("num1")
                .amount(BigDecimal.TEN)
                .currency("RUB").build()
        );
    }

    @SneakyThrows
    @Override
    public BankBookDto findById(Integer id) {
        BankBookDto bankBookDto = bankBookDtoMap.get(id);
        if (bankBookDto==null) {
            throw new BankBookNotFoundException("Счет " + id + " не найден!" );
        }
        return bankBookDto;
    }

    @SneakyThrows
    @Override
    public List<BankBookDto> findByUserId(Integer userId) {
        List<BankBookDto> bankBookDtos = bankBookDtoMap.values().stream()
                .filter(bankBookDto -> userId.equals(bankBookDto.getUserId()))//фильтруем оставляя те которые совпадают с входным параметром userId
                .collect(Collectors.toList()); //отфильтрованные данные формируем в коллекцию
        if (CollectionUtils.isEmpty(bankBookDtos)){
            throw new BankBookNotFoundException("Для данного пользователя " + userId + " нет счетов");
        }
        return bankBookDtos;
    }

    @Override
    @SneakyThrows
    public BankBookDto create(BankBookDto bankBookDto) {
        boolean hasBankBook = bankBookDtoMap.values().stream() // логика того что мы не можем создать счет если такой уже есть по номеру и по валюте
                .anyMatch(bankBook -> bankBook.getUserId().equals(bankBookDto.getUserId())
                && bankBook.getNumber().equals(bankBookDto.getNumber())
                && bankBook.getCurrency().equals(bankBookDto.getCurrency()));
        if (hasBankBook){
            throw new BankBookWithCurrencyAlreadyHaveException("Счет # " + bankBookDto.getNumber() + " c валютой уже имеется!");
        }
        int id = sequenceId.getAndIncrement();
        bankBookDto.setId(id);
        bankBookDtoMap.put(id, bankBookDto); //создание счета
        return bankBookDto;
    }

    @Override
    @SneakyThrows
    public BankBookDto update(BankBookDto bankBookDto) {
        BankBookDto bankBookDtoFromMap = bankBookDtoMap.get(bankBookDto.getId());
        if (bankBookDtoFromMap == null) {
            throw new BankBookNotFoundException("Лицевой # " + bankBookDto.getId() + " счет не найден!");
        }
        if (!bankBookDtoFromMap.getNumber().equals(bankBookDto.getNumber())) {
            throw new BankBookNumberCannotBeModifiedException("Лицевой # " + bankBookDto.getNumber() + " счет менять нельзя!");
        }
        bankBookDtoMap.put(bankBookDto.getId(), bankBookDto);
        return bankBookDto;
    }

    @Override
    public void delete(Integer id) {
        bankBookDtoMap.remove(id);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        List<Integer> bankBookRemoveId = bankBookDtoMap.values().stream()
                .filter(bankBookDto -> bankBookDto.getUserId().equals(userId))
                .map(BankBookDto::getId)
                .collect(Collectors.toList());

        for (Integer removeId : bankBookRemoveId){
            bankBookDtoMap.remove(removeId);
        }
    }

    public void deleteByUserIdOther(Integer userId){
        Iterator<BankBookDto> iterator = bankBookDtoMap.values().iterator();
        while (iterator.hasNext()){
            BankBookDto bankBookDto = iterator.next();
            if (bankBookDto.getUserId().equals(userId)){
                iterator.remove();
            }
        }
    }
}
