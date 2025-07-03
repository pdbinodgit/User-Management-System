package com.usermanagementsystem.usermanagementsystem.sample.service;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.model.User;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public List<UserDto> findAllUser();
}
