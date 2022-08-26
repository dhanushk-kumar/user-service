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
    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(defaultValue = "0") Integer page,@RequestParam(defaultValue = "10") Integer pageSize){
        List<UserDto> userResponses = userService.getUsers(page,pageSize);
        return new ResponseEntity<List<UserDto>>(userResponses, HttpStatus.OK);
    }
    @DeleteMapping("users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        String result = userService.deleteUser(userId);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable String userId) {
        UserDto userDtoResponse = userService.getUserDetails(userId);
        return new ResponseEntity<UserDto>(userDtoResponse, HttpStatus.OK);
    }

    @PutMapping("users/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long userId, @RequestBody User User){
        return new ResponseEntity<UserDto>(userService.updateUser(userId, User), HttpStatus.OK);
    }
    @GetMapping("users/getUserByEmail/{email}")
    public ResponseEntity<UserDto> getUserDetailsByEmail(@PathVariable String email) {
        UserDto res = userService.getUserDetailsByEmail(email);
        return new ResponseEntity<UserDto>(res, HttpStatus.OK);
    }
}
