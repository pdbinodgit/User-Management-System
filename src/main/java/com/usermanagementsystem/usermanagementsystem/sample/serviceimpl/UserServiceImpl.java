package com.usermanagementsystem.usermanagementsystem.sample.serviceimpl;

import com.usermanagementsystem.usermanagementsystem.sample.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.sample.model.User;
import com.usermanagementsystem.usermanagementsystem.sample.repository.UserRepository;
import com.usermanagementsystem.usermanagementsystem.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return mapToDto(userRepository.save(mapToEntity(userDto)));
    }

    @Override
    public List<UserDto> findAllUser() {
       List<UserDto>userDtoList= userRepository.findAll().stream().map(user -> mapToDto(user)).toList();
        return userDtoList;
    }

    public User mapToEntity(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(user.getEmail());
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
