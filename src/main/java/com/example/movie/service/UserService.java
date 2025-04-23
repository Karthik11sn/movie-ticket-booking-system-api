package com.example.movie.service;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;


public interface UserService {
    UserResponse addUser(UserRegistrationRequestDto user);
}
