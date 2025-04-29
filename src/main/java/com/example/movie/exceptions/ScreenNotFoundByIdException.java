package com.example.movie.exceptions;

import lombok.Getter;

@Getter
public class ScreenNotFoundByIdException extends RuntimeException {
    private String message;

    public ScreenNotFoundByIdException(String message) {
        super(message);
    }
}
