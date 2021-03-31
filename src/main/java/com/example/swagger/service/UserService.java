package com.example.swagger.service;

import com.example.swagger.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserData();

    List<UserDTO> getUserList();
}
