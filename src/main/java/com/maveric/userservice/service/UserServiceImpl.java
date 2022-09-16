package com.maveric.userservice.service;

import com.maveric.userservice.dto.UserDto;
import com.maveric.userservice.exceptionhandler.UserNotExist;
import com.maveric.userservice.mapper.UserMapper;
import com.maveric.userservice.model.User;
import com.maveric.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.maveric.userservice.Utility.ModelDtoTransformer.toDto;
import static com.maveric.userservice.Utility.ModelDtoTransformer.toEntity;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;
    public List<UserDto> getUsers(Integer page, Integer pageSize) {
        Pageable paging = (Pageable) PageRequest.of(page, pageSize);
        Page<User> pageResult = repository.findAll(paging);
        if(pageResult.hasContent()) {
            return pageResult.getContent().stream()
                    .map(
                            user -> toDto(user)
                    ).collect(
                            Collectors.toList()
                    );
        } else {
            return new ArrayList<>();
        }
    }
    public UserDto createUser(UserDto userResponse) {
        //Adding CreatedTime

        User user = toEntity(userResponse);
        User userResult = repository.save(user);
        return  toDto(userResult);
    }

    @Override
    public UserDto getUserDetails(String userId) {
        User getResult=repository.findById(Long.valueOf(userId)).orElseThrow(() -> new UserNotExist("user not found"));
        return toDto(getResult);
    }

    @Override
    public String deleteUser(String userId) {
        repository.deleteById(Long.valueOf(userId));
        return "The user is deleted successfully.";
    }

    public UserDto getUserDetailsByEmail(String email) {
        User getEmailResult = repository.findByEmail(email);
        return toDto(getEmailResult);
    }

    @Override
    public UserDto updateUser(long userId, User user) {

        User updateUser = repository.findById(userId).orElseThrow(()-> new UserNotExist("User Not Found"));
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setMiddleName(user.getMiddleName());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setEmail(user.getEmail());
        updateUser.setAddress(user.getAddress());
        updateUser.setDateOfBirth(user.getDateOfBirth());
        updateUser.setGender(user.getGender());
        return toDto(repository.save(updateUser));
    }
}
