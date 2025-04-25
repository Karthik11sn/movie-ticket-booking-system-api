package com.example.movie.controller;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;
import com.example.movie.dto.UserUpdationRequest;
import com.example.movie.entity.UserDetails;
import com.example.movie.service.UserService;
import com.example.movie.util.ResponseStructure;
import com.example.movie.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequestDto user){
        UserResponse userDetails=userService.addUser(user);
        return responseBuilder.sucess(HttpStatus.OK,"New User details has been added",userDetails);
    }

    @PostMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> editUser(@PathVariable String email, @RequestBody UserUpdationRequest user){
        UserResponse userDetails=userService.editUser(user,email);
        return responseBuilder.sucess(HttpStatus.OK,"User details has been updated",userDetails);
    }


    @DeleteMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> softDeleteUser(@PathVariable String email) {
        UserResponse userDetails = userService.softDeleteUser (email);
        return responseBuilder.sucess(HttpStatus.OK, "User  account has been deleted", userDetails);
    }
    }

