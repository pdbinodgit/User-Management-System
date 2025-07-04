package com.usermanagementsystem.usermanagementsystem.sample.service;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public Page<User> findAllUser(int pagesize, int pageNumber);

    public UserDto updateUser(UserDto userDto);

    public UserDto findById(Long id);
}
