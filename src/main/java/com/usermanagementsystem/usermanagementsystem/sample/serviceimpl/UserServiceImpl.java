package com.usermanagementsystem.usermanagementsystem.sample.serviceimpl;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.model.User;
import com.usermanagementsystem.usermanagementsystem.sample.repository.UserRepository;
import com.usermanagementsystem.usermanagementsystem.sample.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return mapToDto(userRepository.save(mapToEntity(userDto)));
    }

    @Override
    public Page<User> findAllUser(int pageSize, int pageNumber) {
        Page<User> users=userRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return users;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> userOptional=userRepository.findById(userDto.getId());
        if (userOptional.isPresent()){
            userOptional.get().setName(userDto.getName());
            userOptional.get().setEmail(userDto.getEmail());
            userRepository.save(userOptional.get());
            return mapToDto(userOptional.get());
        }else {
            return null;
        }
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        return userOptional.map(this::mapToDto).orElse(null);
    }


    public User mapToEntity(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    public UserDto mapToDto(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
