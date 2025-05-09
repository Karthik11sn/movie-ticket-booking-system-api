package com.example.movie.service.serviceImpl;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;
import com.example.movie.dto.UserUpdationRequest;
import com.example.movie.entity.TheaterOwner;
import com.example.movie.entity.User;
import com.example.movie.entity.UserDetails;
import com.example.movie.exceptions.UserExistByEmailException;
import com.example.movie.exceptions.UserNotFoundByEmailException;
import com.example.movie.mapper.UserDetailsMapper;
import com.example.movie.repository.UserRepository;
import com.example.movie.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponse addUser(UserRegistrationRequestDto user) {
        if (userRepository.existsByEmail(user.email()))
            throw new UserExistByEmailException("User with the Email is already exists");

        UserDetails userDetails = switch (user.userRole()) {
            case USER -> copy(new User(), user);
            case THEATER_OWNER -> copy(new TheaterOwner(), user);
        };
        return userMapper.userDetailsResponseMapper(userDetails);
    }

    @Override
    public UserResponse editUser(UserUpdationRequest userRequest, String email) {
        if (userRepository.existsByEmail(email)) {
            UserDetails user = userRepository.findByEmail(email);

            if (! user.getEmail().equals(userRequest.email()) && userRepository.existsByEmail(userRequest.email())){
                throw new UserExistByEmailException("User with the email already exists");
            }


            user = copy(user, userRequest);

            return userMapper.userDetailsResponseMapper(user);
        }

        throw new UserNotFoundByEmailException("Email not found in the Database");
    }

    @Override
    public UserResponse softDeleteUser(String email) {
        if (userRepository.existsByEmail(email)) {
            UserDetails user = userRepository.findByEmail(email);
            user.setDelete(true);
            user.setDeletedAt(Instant.now());
            userRepository.save(user);
            return userMapper.userDetailsResponseMapper(user);
        }
        throw new UserNotFoundByEmailException("Email not found in the Database");
    }

    private UserDetails copy(UserDetails userRole, UserRegistrationRequestDto user) {
        userRole.setUserRole(user.userRole());
        userRole.setPassword(passwordEncoder.encode(user.password()));
        userRole.setEmail(user.email());
        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setUsername(user.username());
        userRole.setDelete(false);
        userRepository.save(userRole);
        return userRole;
    }

    private UserDetails copy(UserDetails userRole, UserUpdationRequest user) {
        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setEmail(user.email());
        userRole.setUsername(user.username());
        userRole.setDelete(false);
        userRepository.save(userRole);
        return userRole;
    }
}
