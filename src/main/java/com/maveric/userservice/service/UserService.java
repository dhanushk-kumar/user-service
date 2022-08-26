package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exceptionhandler.UserNotExist;
import com.maveric.userservice.model.User;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers(Integer page, Integer pageSize);
    public UserDto createUser(UserDto userResponse);

    public UserDto getUserDetails(String userId);

    public String deleteUser(String userId);

    public UserDto  getUserDetailsByEmail(String email);

    public UserDto updateUser(long userId, User user) throws UserNotExist;


}
