package com.maveric.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.repository.UserRepository;
import com.maveric.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper map;
    @MockBean
    private UserService mockService;
    @MockBean
    private UserRepository mockRepo;

    @Test
    void shouldGetUsersWhenRequestMadeToGetUser() throws Exception {
        mvc.perform(get("/api/v1/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void ShouldCreateUserWhenPostUserIsInvoked() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Chan's");
        userDto.setLastName("Kumar");
        userDto.setMiddleName("Kumar");
        userDto.setPhoneNumber("098765432");
        userDto.setEmail("dhana@gmail.com");
        userDto.setDateOfBirth("12-02-1998");
        userDto.setAddress("Chennai");
        userDto.setGender("Male");

        String url = "/api/v1/users";
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(map.writeValueAsBytes(userDto)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void shouldGetUserDetailsWhenGetUserByIdInvoked() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Chan's");
        userDto.setLastName("Kumar");
        userDto.setMiddleName("Kumar");
        userDto.setPhoneNumber("098765432");
        userDto.setEmail("dhana@gmail.com");
        userDto.setDateOfBirth("12-02-1998");
        userDto.setAddress("Chennai");
        userDto.setGender("Male");

        String url = "/api/v1/users/" + "1";
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void ShouldDeleteUserWhenDeleteUserByIdRequestIsMade() throws Exception {

        mvc.perform(delete("/api/v1/users/" + "1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldGetUserDetailsWhenGetUserByEmailInvoked() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Chan's");
        userDto.setLastName("Kumar");
        userDto.setMiddleName("Kumar");
        userDto.setPhoneNumber("098765432");
        userDto.setEmail("dhana@gmail.com");
        userDto.setDateOfBirth("12-02-1998");
        userDto.setAddress("Chennai");
        userDto.setGender("Male");

        String url = "/api/v1/users/getUserByEmail/" + "dhana@gmail.com";
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
