package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UseService {

    List<UserDto> getAll();
    UserDto getById(Integer id);
    UserDto create(UserDto userDto);
    UserDto update(UserDto userDto);
    void delete(Integer id);
}
