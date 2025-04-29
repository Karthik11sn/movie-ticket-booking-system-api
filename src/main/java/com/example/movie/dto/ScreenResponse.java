package com.example.movie.dto;

import com.example.movie.entity.Seat;
import com.example.movie.enums.ScreenType;
import lombok.Builder;

import java.util.List;

@Builder
public record ScreenResponse(
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows,
        List<Seat> seats

) {
}
