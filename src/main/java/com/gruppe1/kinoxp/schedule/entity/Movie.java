package com.gruppe1.kinoxp.schedule.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


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

    double length;

    Genre genres;


    public Movie(String name, String description, double length, Genre genres) {
        this.name = name;
        this.description = description;
        this.length = length;
        this.genres = genres;
    }
}
