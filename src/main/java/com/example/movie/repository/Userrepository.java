package com.example.movie.repository;

import com.example.movie.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<UserDetails,Long> {
    boolean existsByEmail(String email);
}
