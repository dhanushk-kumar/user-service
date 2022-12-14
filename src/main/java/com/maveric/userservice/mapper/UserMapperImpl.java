package com.maveric.userservice.mapper;


import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User map(UserDto userResponse) {
        return new User(
                userResponse.getId(),
                userResponse.getFirstName(),
                userResponse.getLastName(),
                userResponse.getMiddleName(),
                userResponse.getPhoneNumber(),
                userResponse.getEmail(),
                userResponse.getAddress(),
                userResponse.getDateOfBirth(),
                userResponse.getGender()

        );
    }

    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getAddress(),
                user.getDateOfBirth(),
                user.getGender()
        );
    }

    @Override
    public List<User> map(List<UserDto> userResponses) {
        List<User> list = new ArrayList<User>(userResponses.size());
        for(UserDto userResult:userResponses)
        {
            list.add(map(userResult));
        }
        return list;
    }
}
