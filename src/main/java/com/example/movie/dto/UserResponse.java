package com.example.movie.dto;

import com.example.movie.enums.UserRole;
import lombok.Builder;

@Builder
public record UserResponse( String userId,
                            String username,
                            String email,
                            String phoneNumber,
                            UserRole userRole) {
}
