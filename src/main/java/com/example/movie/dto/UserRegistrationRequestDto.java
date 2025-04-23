package com.example.movie.dto;

import com.example.movie.enums.UserRole;

import java.time.LocalDate;

public record UserRegistrationRequestDto(String username,
                                         String email,
                                         String password,
                                         String phoneNumber,
                                         UserRole userRole,
                                         LocalDate dateOfBirth) {
}
