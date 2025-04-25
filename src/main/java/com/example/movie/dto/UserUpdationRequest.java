package com.example.movie.dto;

import java.time.LocalDate;

public record UserUpdationRequest(String username,
                                  String email,
                                  String phoneNumber,
                                  LocalDate dateOfBirth) {
}
