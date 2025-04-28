package com.example.movie.repository;

import com.example.movie.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater,String> {
}
