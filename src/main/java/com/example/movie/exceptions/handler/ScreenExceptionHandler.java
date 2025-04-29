package com.example.movie.exceptions.handler;


import com.example.movie.exceptions.NoOfRowsExceedCapacityException;
import com.example.movie.exceptions.ScreenNotFoundByIdException;
import com.example.movie.util.ErrorStructure;
import com.example.movie.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class ScreenExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleNoOfRowsExceedCapacityException(NoOfRowsExceedCapacityException ex) {
        return responseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleScreenNotFoundByIdException(ScreenNotFoundByIdException ex) {
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
