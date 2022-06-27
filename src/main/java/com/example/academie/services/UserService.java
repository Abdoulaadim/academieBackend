package com.example.academie.services;

import com.example.academie.dto.UserDto;
import com.example.academie.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> getAllUsers();
    UserDto addUser(UserDto user);
    UserDto getUser(String email);
    boolean delete(String id);
    UserDto getByIdUser(String id);
    UserDto updateUser(String id,UserDto userDto) throws Exception;
}
