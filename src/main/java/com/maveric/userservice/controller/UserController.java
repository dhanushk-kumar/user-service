package com.maveric.userservice.controller;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userResponse) {
        UserDto userDtoResponse = userService.createUser(userResponse);
        return new ResponseEntity<UserDto>(userDtoResponse, HttpStatus.OK);
    }
}
