package com.gruppe1.kinoxp.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "hallNumber")
    @JsonBackReference
    Hall hall;


    public Movie(String name, String description, int hours, int minutes, Genre genres, LocalTime startTime, Hall hall) {
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.minutes = minutes;
        this.genres = genres;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(hours).plusMinutes(minutes);
        this.hall = hall;
    }
}
