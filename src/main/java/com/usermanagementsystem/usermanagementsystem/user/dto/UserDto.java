package com.usermanagementsystem.usermanagementsystem.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usermanagementsystem.usermanagementsystem.role.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    List<Role> roles;
}
