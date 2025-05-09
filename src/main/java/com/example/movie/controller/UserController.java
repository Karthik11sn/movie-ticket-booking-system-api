package com.example.movie.controller;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;
import com.example.movie.dto.UserUpdationRequest;
import com.example.movie.entity.UserDetails;
import com.example.movie.service.UserService;
import com.example.movie.util.ResponseStructure;
import com.example.movie.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRegistrationRequestDto user){
        UserResponse userDetails = userService.addUser(user);
        return responseBuilder.sucess(HttpStatus.OK,"New User Details Has been added", userDetails);
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> editUser(@PathVariable String email, @RequestBody @Valid UserUpdationRequest user){
        UserResponse userDetails = userService.editUser(user, email);
        return responseBuilder.sucess(HttpStatus.OK,"User Details has been updated", userDetails);
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> softDeleteUser(@PathVariable String email){
        UserResponse userDetails = userService.softDeleteUser(email);
        return responseBuilder.sucess(HttpStatus.OK,"UserDetails account has been deleted ", userDetails);
    }
    }

