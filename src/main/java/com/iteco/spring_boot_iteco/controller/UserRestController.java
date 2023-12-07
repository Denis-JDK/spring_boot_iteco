package com.iteco.spring_boot_iteco.controller;

import com.iteco.spring_boot_iteco.model.UserDto;
import com.iteco.spring_boot_iteco.service.UseService;
import org.springframework.http.*;
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
    public ResponseEntity <UserDto> getUserById(@PathVariable Integer id){ //необходим ResponseEntity так как мы работаем с заголовками response, для задания cocke в headers response.
        UserDto userDto = useService.getById(id);
        ResponseCookie userId = ResponseCookie.from("userId", userDto.getId().toString()).maxAge(600).build(); //генерим cocke для клиента.
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, userId.toString()) //set cookie в response
                .body(userDto);
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
