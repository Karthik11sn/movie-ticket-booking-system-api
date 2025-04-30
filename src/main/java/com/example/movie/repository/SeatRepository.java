package com.example.movie.repository;

import com.example.movie.entity.Screen;
import com.example.movie.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,String> {
    List<Seat> findByScreenAndIsDeleteFalse(Screen screen);
}
