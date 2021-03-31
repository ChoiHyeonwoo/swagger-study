package com.example.swagger.service.impl;

import com.example.swagger.service.UserService;
import com.example.swagger.service.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO getUserData() {

        return UserDTO.builder()
                .email("escape0619@gmail.com")
                .name("hwchoi")
                .password("1234")
                .build();
    }
}
