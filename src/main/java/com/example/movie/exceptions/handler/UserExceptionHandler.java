package com.example.movie.exceptions.handler;

import com.example.movie.exceptions.UserExistByEmailException;
import com.example.movie.exceptions.UserNotFoundByEmailException;
import com.example.movie.util.ErrorStructure;
import com.example.movie.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserExistByEmailException(UserExistByEmailException ex){
        return responseBuilder.error(HttpStatus.OK, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUserNotFoundByEmailException(UserNotFoundByEmailException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
