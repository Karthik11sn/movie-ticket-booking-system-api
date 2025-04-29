package com.example.movie.mapper;

import com.example.movie.dto.ScreenResponse;
import com.example.movie.entity.Screen;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {
    public ScreenResponse screenResponseMapper(Screen screen) {
        if (screen == null)
            return null;
        return new ScreenResponse(
                screen.getScreenId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows(),
                screen.getSeats()

        );
    }
}
