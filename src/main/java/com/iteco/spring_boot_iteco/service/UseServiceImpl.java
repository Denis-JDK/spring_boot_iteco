package com.iteco.spring_boot_iteco.service;

import com.iteco.spring_boot_iteco.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class UseServiceImpl implements UseService{

    private final Map<Integer, UserDto> userDtoMap = new ConcurrentHashMap<>();
    private final AtomicInteger sequenceId = new AtomicInteger(1);
    @PostConstruct
    void init(){
        int id = sequenceId.getAndIncrement();
        userDtoMap.put(id, UserDto.builder()
                .id(id)
                .email("email@email.com")
                .name("NAME").build());
    }
    @Override
    public List<UserDto> getAll() {
        return new ArrayList<>(userDtoMap.values());
    }

    @Override
    public UserDto getById(Integer id) {
        return userDtoMap.get(id);
    }

    @Override
    public UserDto create(UserDto userDto) {
        int id = sequenceId.getAndIncrement();
        userDto.setId(id);
        userDtoMap.put(id, userDto);
        return userDto;
    }

    @Override
    public UserDto update(UserDto userDto) {
        UserDto userDtoFromMap = userDtoMap.get(userDto.getId());
        if (userDtoFromMap == null){
            return null;
        }else{
            userDtoMap.put(userDto.getId(), userDto);
            return userDto;
        }
    }

    @Override
    public void delete(Integer id) {
        userDtoMap.remove(id);

    }
}
