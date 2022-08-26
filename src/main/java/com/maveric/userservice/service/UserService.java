package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exceptionhandler.UserNotExist;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userResponse);
    public List<UserDto> getUsers(Integer page,Integer pageSize);
    public String deleteUser(String userId);
    public UserDto getUserDetails(String userId);
}
