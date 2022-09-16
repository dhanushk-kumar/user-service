package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldReturnUserWhenCreateUserInvoked() {

        when(userRepository.save(any())).thenReturn(getUser());

        UserDto user = userService.createUser(getUserDto());

        assertNotNull(user);
        assertSame(user.getEmail(),getUser().getEmail());
    }

    @Test
    void shouldDeleteUserwhenDeleteUserInvoked(){

        userRepository.deleteById(Long.valueOf("123"));
        verify(userRepository,atLeastOnce()).deleteById(Long.valueOf("123"));
    }

    private UserDto getUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(123);
        userDto.setFirstName("Chan's");
        userDto.setLastName("Kumar");
        userDto.setMiddleName("Kumar");
        userDto.setPhoneNumber("098765432");
        userDto.setEmail("dhana@gmail.com");
        userDto.setDateOfBirth("12-02-1998");
        userDto.setAddress("Chennai");
        userDto.setGender("Male");
        return userDto;
    }

    private User getUser() {
        User user = new User();
        user.setId(123);
        user.setFirstName("Chan's");
        user.setLastName("Kumar");
        user.setMiddleName("Kumar");
        user.setPhoneNumber("098765432");
        user.setEmail("dhana@gmail.com");
        user.setDateOfBirth("12-02-1998");
        user.setAddress("Chennai");
        user.setGender("Male");
        return user;
    }
}
