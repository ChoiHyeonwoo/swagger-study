package com.example.swagger.service.impl;

import com.example.swagger.service.UserService;
import com.example.swagger.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<UserDTO> getUserList() {
        List<UserDTO> userDTOList = new ArrayList<>();

        UserDTO userDTO1 = UserDTO.builder()
                .email("escape0619@gmail.com")
                .name("hwchoi")
                .password("1234")
                .build();

        UserDTO userDTO2 = UserDTO.builder()
                .email("bananakick12@naver.com")
                .name("hwchoi")
                .password("1234")
                .build();

        userDTOList.add(userDTO1);
        userDTOList.add(userDTO2);

        return userDTOList;
    }
}
