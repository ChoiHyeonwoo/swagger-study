package com.example.swagger.controller;

import com.example.swagger.service.UserService;
import com.example.swagger.service.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    @Operation(summary = "사용자의 상세정보를 리턴합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 정보를 리턴합니다.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "유효하지 않는 사용자 정보입니다.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "없는 사용자 입니다.",
                    content = @Content) })
    public UserDTO getUserData(){
        return userService.getUserData();
    }
}
