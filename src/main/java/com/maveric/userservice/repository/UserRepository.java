package com.maveric.userservice.repository;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
