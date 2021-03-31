package com.example.swagger.controller;

import com.example.swagger.service.UserService;
import com.example.swagger.service.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "UserController", description = "사용자 API")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "사용자의 상세정보를 리턴합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자 정보를 리턴합니다.",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "유효하지 않는 사용자 정보입니다.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "없는 사용자 입니다.",
                    content = @Content) })
    @Parameter(name = "id", description = "UserEntity의 PK(PathVariable 형태)",
            required = true, example = "53")
    @GetMapping("/user/{id}")
    public UserDTO getUserData(@PathVariable Long id){
        return userService.getUserData();
    }

    @Operation(summary = "사용자의 리스트를 리턴합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "사용자의 리스트를 리턴합니다.",
                    content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
                    }),
            @ApiResponse(responseCode = "400", description = "검색조건이 옳지 않습니다.",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "검색조건에 맞는 사용자가 존재하지 않습니다.",
                    content = @Content) })
    @Parameter(name = "name", description = "사용자의 이름",
            example = "hwchoi")
    @GetMapping("/users")
    public List<UserDTO> getUserList(@RequestParam String name){
        return userService.getUserList();
    }
}
