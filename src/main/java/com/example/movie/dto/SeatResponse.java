package com.example.movie.dto;

import lombok.Builder;

import java.util.List;
@Builder
public record SeatResponse(
        String seatId,
        String name
) {
}
