package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exceptionhandler.UserNotExist;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.maveric.userservice.utility.ModelDtoTransformer.toDto;
import static com.maveric.userservice.utility.ModelDtoTransformer.toEntity;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

}
