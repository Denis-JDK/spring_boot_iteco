package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.UserDto;

import java.util.List;

public interface UseService {

    List<UserDto> getAll();
    UserDto getById(Integer id);
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto);
    void delete(Integer id);
}
