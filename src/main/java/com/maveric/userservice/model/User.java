package com.maveric.userservice.model;

import com.maveric.userservice.constants.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Document(collection = "Users")
public class User {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dateOfBirth;
    private String gender;
}
