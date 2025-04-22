package com.example.movie.service.serviceImpl;

import com.example.movie.entity.TheaterOwner;
import com.example.movie.entity.User;
import com.example.movie.entity.UserDetails;
import com.example.movie.exceptions.UserExistByEmailException;
import com.example.movie.repository.Userrepository;
import com.example.movie.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
 private final Userrepository userrepository;

    @Override
    public UserDetails addUser(UserDetails user) {
        if (!userrepository.existsByEmail(user.getEmail())){
            //return copy(user);
            switch (user.getUserRole()){
                case USER ->copy(new User(),user);
                case THEATER_OWNER ->copy(new TheaterOwner(),user);

            }
        }
        throw new UserExistByEmailException("user with the Email is alredy exists");
    }
    private UserDetails copy(UserDetails userRole,UserDetails user){
        //Userdeatials userRole =user.getUserRole()==UserRole.USER? new user()
        userRole.setUserRole(user.getUserRole());
        userRole.setEmail(user.getEmail());
        userRole.setPassword(user.getPassword());
        userRole.setCreatedAt(user.getCreatedAt());
        userRole.setDateOfBirth(user.getDateOfBirth());
        userRole.setPhoneNumber(user.getPhoneNumber());
        userRole.setUsername(user.getUsername());
        userRole.setUpdateAt(user.getUpdateAt());
        userrepository.save(userRole);
        return userRole;

    }
}

