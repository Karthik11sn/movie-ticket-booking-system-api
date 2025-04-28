package com.example.movie.mapper;

import com.example.movie.dto.TheaterResponse;
import com.example.movie.entity.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterMapper {
    public TheaterResponse theaterResponseMapper(Theater theater) {
        if (theater == null)
            return null;
        return new TheaterResponse(
                theater.getTheaterId(),
                theater.getName(),
                theater.getAddress(),
                theater.getCity(),
                theater.getLandmark()
        );
    }
}
