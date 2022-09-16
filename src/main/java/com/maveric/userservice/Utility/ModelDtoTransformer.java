package com.maveric.userservice.Utility;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;

public class ModelDtoTransformer {
    public static User toEntity(UserDto userResponse) {
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

    public static UserDto toDto(User user) {
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
}
