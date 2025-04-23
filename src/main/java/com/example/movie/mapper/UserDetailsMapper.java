package com.example.movie.mapper;

import com.example.movie.dto.UserResponse;
import com.example.movie.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserResponse userDetailsResponseMapper(UserDetails userDetails){
        if (userDetails==null)
            return null;
        return new UserResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getUserRole()
        );
    }
    }

