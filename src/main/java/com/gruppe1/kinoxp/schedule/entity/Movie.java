package com.gruppe1.kinoxp.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String description;

    int hours;
    int minutes;

    Genre genres;

    private LocalDateTime movieStartTime;

    private LocalDateTime movieEndTime;

    LocalDateTime advertisementStartTime;

    LocalDateTime cleaning;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hallNumber")
    @JsonBackReference
    Hall hall;


    public Movie(String name, String description, int hours, int minutes, Genre genres, LocalDateTime advertisementStartTime, Hall hall) {
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.minutes = minutes;
        this.genres = genres;
        this.advertisementStartTime = advertisementStartTime;
        this.movieStartTime = advertisementStartTime.plusMinutes(20);
        this.movieEndTime = movieStartTime.plusHours(hours).plusMinutes(minutes);
        this.cleaning = movieEndTime.plusMinutes(30);
        this.hall = hall;
    }
}
