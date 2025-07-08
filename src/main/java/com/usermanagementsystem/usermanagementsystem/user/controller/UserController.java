package com.usermanagementsystem.usermanagementsystem.user.controller;

import com.usermanagementsystem.usermanagementsystem.user.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.user.model.User;
import com.usermanagementsystem.usermanagementsystem.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/url/user/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
        return ResponseEntity.ok("Save Sucessfully.");
    }

    @GetMapping("/user/getAllUser")
    public Page<User> getAllUser(@RequestParam int size, @RequestParam int number) {
        return userService.findAllUser(size, number);
    }

    @PutMapping("/user/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return ResponseEntity.ok("Updated successfully.");
    }

    @GetMapping("/getById/{id}")
    public UserDto getById(@PathVariable Long id){
        return userService.findById(id);
    }
    @GetMapping("/findByName")
    public Page<User> findByName(@RequestParam String keyword,
                                 @RequestParam int pageSize,
                                 @RequestParam int pageNumber) {
        return userService.findByName(keyword, pageSize, pageNumber);
    }
}
