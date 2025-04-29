package com.example.movie.service;

import com.example.movie.dto.TheaterRequest;
import com.example.movie.dto.TheaterResponse;

public interface TheaterService {
    TheaterResponse addTheater(String email, TheaterRequest theaterRequest);
    TheaterResponse findTheater(String theaterId);
    TheaterResponse updateTheater(String theaterId, TheaterRequest registerationRequest);

}
