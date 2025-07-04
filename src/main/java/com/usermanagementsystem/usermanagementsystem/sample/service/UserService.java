package com.usermanagementsystem.usermanagementsystem.sample.service;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public List<UserDto> findAllUser();

    public UserDto updateUser(UserDto userDto);

    public UserDto findById(Long id);
}
