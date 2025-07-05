package com.usermanagementsystem.usermanagementsystem.user.service;

import com.usermanagementsystem.usermanagementsystem.user.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.user.model.User;
import org.springframework.data.domain.Page;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public Page<User> findAllUser(int pagesize, int pageNumber);

    public UserDto updateUser(UserDto userDto);

    public UserDto findById(Long id);

    public Page<User> findByName(String keyword,int pagesize, int pageNumber);
}
