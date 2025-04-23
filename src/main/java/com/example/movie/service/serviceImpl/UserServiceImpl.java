package com.example.movie.service.serviceImpl;

import com.example.movie.dto.UserRegistrationRequestDto;
import com.example.movie.dto.UserResponse;
import com.example.movie.entity.TheaterOwner;
import com.example.movie.entity.User;
import com.example.movie.entity.UserDetails;
import com.example.movie.exceptions.UserExistByEmailException;
import com.example.movie.mapper.UserDetailsMapper;
import com.example.movie.repository.UserRepository;
import com.example.movie.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

 private final UserRepository userrepository;
 private final UserDetailsMapper userMapper;

    @Override
    public UserResponse addUser(UserRegistrationRequestDto user) {
        if (!userrepository.existsByEmail(user.email()))
            throw new UserExistByEmailException("user with the Email is alredy exists");
        //return copy(user);
        UserDetails userDetails = switch (user.userRole()) {
            case USER -> copy(new User(), user);
            case THEATER_OWNER -> copy(new TheaterOwner(), user);

        };
        return userMapper.userDetailsResponseMapper(userDetails);

    }


    private UserDetails copy(UserDetails userRole,UserRegistrationRequestDto user){
        //Userdeatials userRole =user.getUserRole()==UserRole.USER? new user()
        userRole.setUserRole(user.userRole());
        userRole.setEmail(user.email());
        userRole.setPassword(user.password());

        userRole.setDateOfBirth(user.dateOfBirth());
        userRole.setPhoneNumber(user.phoneNumber());
        userRole.setUsername(user.username());
        userrepository.save(userRole);
        return userRole;

    }



}

