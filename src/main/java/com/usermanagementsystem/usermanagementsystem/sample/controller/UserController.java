package com.usermanagementsystem.usermanagementsystem.sample.controller;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.ok("Save Sucessfully.");
    }

    @GetMapping("/getAllUser")
    public List<UserDto> getAllUser(){
        return userService.findAllUser();
    }
}
