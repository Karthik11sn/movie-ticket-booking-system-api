package com.example.movie.service;

import com.example.movie.dto.ScreenRequest;
import com.example.movie.dto.ScreenResponse;

public interface ScreenService {
    ScreenResponse addScreen(ScreenRequest screenRequest, String theaterId);

    ScreenResponse findScreen(String theaterId, String screenId);


}
