package com.example.movie.repository;

import com.example.movie.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen,String> {
}
