package com.maveric.userservice.repository;

import com.maveric.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {

}
