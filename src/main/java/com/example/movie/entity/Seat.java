package com.example.movie.entity;

import com.example.movie.enums.ScreenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Seat {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String seatId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Screen screen;

    private Boolean isDelete;
    private LocalDateTime deletedAt;


    @CreatedDate
    private LocalDateTime createdAt;

}
