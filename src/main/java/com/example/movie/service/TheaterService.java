package com.example.movie.service;

import com.example.movie.dto.TheaterRegisterationRequest;
import com.example.movie.dto.TheaterResponse;

public interface TheaterService {
    TheaterResponse addTheater(String email, TheaterRegisterationRequest theaterRegisterationRequest);

}
