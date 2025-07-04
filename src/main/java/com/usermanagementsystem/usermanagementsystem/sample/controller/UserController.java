package com.usermanagementsystem.usermanagementsystem.sample.controller;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.model.User;
import com.usermanagementsystem.usermanagementsystem.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<User> getAllUser(@RequestParam int size, @RequestParam int number) {
        return userService.findAllUser(size, number);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(UserDto userDto){
        userService.updateUser(userDto);
        return ResponseEntity.ok("Updated successfully.");
    }

    @GetMapping("/getById/{id}")
    public UserDto getById(@PathVariable Long id){
        return userService.findById(id);
    }
}
