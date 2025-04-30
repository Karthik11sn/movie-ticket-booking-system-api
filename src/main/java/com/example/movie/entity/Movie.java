package com.example.movie.entity;

import com.example.movie.enums.Certificate;
import com.example.movie.enums.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.Duration;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ElementCollection
    private Set<String> castList;

    @Column(name = "runtime")
    private Duration runtime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "certificate")
    private Certificate certificate;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;
}
