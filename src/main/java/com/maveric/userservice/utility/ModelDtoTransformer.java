package com.maveric.userservice.utility;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;

import java.util.Locale;

public class ModelDtoTransformer {
    public static User toEntity(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getMiddleName(),
                dto.getPhoneNumber(),
                dto.getEmail(),
                dto.getAddress(),
                dto.getDateOfBirth(),
                dto.getGender()
        );
    }

    public static UserDto toDto(User model) {
        return new UserDto(
                model.getId(),
                model.getFirstName(),
                model.getLastName(),
                model.getMiddleName(),
                model.getPhoneNumber(),
                model.getEmail(),
                model.getAddress(),
                model.getDateOfBirth(),
                model.getGender()
        );
    }
}
