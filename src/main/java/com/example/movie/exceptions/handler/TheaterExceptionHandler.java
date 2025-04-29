package com.example.movie.exceptions.handler;

import com.example.movie.exceptions.TheaterNotFoundByIdException;
import com.example.movie.util.ErrorStructure;

import com.example.movie.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@AllArgsConstructor
@RestControllerAdvice
public class TheaterExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleTheaterNotFoundByIdException(TheaterNotFoundByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }

}
