package com.example.movie.dto;

import com.example.movie.enums.ScreenType;
import lombok.Builder;

@Builder
public record ScreenResponse(
        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows

) {
}
