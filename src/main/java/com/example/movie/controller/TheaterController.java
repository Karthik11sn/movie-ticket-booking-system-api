package com.example.movie.controller;

import com.example.movie.dto.TheaterRegisterationRequest;
import com.example.movie.dto.TheaterResponse;
import com.example.movie.service.TheaterService;
import com.example.movie.util.ResponseStructure;
import com.example.movie.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/theaters")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(String email, @Valid @RequestBody TheaterRegisterationRequest theaterRegisterationRequest){
        TheaterResponse theaterResponse = theaterService.addTheater(email, theaterRegisterationRequest);
        return responseBuilder.sucess(HttpStatus.OK, "Theater has been succesfull created", theaterResponse);
    }
}
