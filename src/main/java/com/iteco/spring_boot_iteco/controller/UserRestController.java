package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.UserDto;
import com.iteco.spring_boot_iteco.service.UseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    private final UseService useService;

    public UserRestController(UseService useService) {
        this.useService = useService;
    }
    @GetMapping
    public List<UserDto> getAllUser(){
        return useService.getAll();

    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id){
        return useService.getById(id);
    }
    @PostMapping
    public ResponseEntity <UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(useService.create(userDto));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto){
        return useService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        useService.delete(id);
    }
}
