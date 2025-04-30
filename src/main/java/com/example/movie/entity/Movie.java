package com.example.movie.entity;

import com.example.movie.enums.Certificate;
import com.example.movie.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.Duration;

@Entity
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;
    private String title;
    private String description;
    private String[] cast;
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    private Certificate certificate;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
}
