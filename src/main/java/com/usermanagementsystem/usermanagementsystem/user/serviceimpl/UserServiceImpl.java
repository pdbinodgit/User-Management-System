package com.usermanagementsystem.usermanagementsystem.user.serviceimpl;

import com.usermanagementsystem.usermanagementsystem.role.model.Role;
import com.usermanagementsystem.usermanagementsystem.role.repository.RoleRepository;
import com.usermanagementsystem.usermanagementsystem.user.dto.UserDto;
import com.usermanagementsystem.usermanagementsystem.user.model.User;
import com.usermanagementsystem.usermanagementsystem.user.repository.UserRepository;
import com.usermanagementsystem.usermanagementsystem.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {

        userDto.setPassword(encoder.encode(userDto.getPassword()));

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

    @Override
    public Page<User> findByName(String keyword,int pagesize, int pageNumber) {
        return userRepository.findAllByNameContainingIgnoreCase(keyword,PageRequest.of(pageNumber,pagesize));
    }


    public User mapToEntity(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        List<Role> roleList = new ArrayList<>();
        for (Role role : userDto.getRoles()) {
            Role dbRole = roleRepository.findById(role.getId())
                    .orElseThrow(() -> new RuntimeException("Role not found with id: " + role.getId()));
            roleList.add(dbRole);
        }
        user.setRoles(roleList);
        return user;
    }
    public UserDto mapToDto(User user){
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
