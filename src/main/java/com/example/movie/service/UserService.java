package com.example.movie.service;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;
import com.example.movie.dto.UserUpdationRequest;


public interface UserService {
    UserResponse addUser(UserRegistrationRequestDto user);
    UserResponse editUser(UserUpdationRequest userRequest, String email);
    UserResponse softDeleteUser(String email);

}
