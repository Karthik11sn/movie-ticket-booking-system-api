package com.example.movie.dto;
import java.util.List;

import lombok.Builder;

@Builder
public record TheaterResponse(String theaterId,
                              String name,
                              String address,
                              String city,
                              String landmark) {
}
