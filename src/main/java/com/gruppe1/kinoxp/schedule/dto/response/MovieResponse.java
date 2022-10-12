package com.gruppe1.kinoxp.schedule.dto.response;

import com.gruppe1.kinoxp.schedule.entity.Genre;
import com.gruppe1.kinoxp.schedule.entity.Hall;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class MovieResponse {

    int id;

    String name;

    String description;

    int hours;

    int minutes;

    Genre genres;

    private LocalTime startTime;

    private LocalTime endTime;

    Hall hall;

    public MovieResponse(Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.hours = movie.getHours();
        this.minutes = movie.getMinutes();
        this.genres = movie.getGenres();
        this.startTime = movie.getStartTime();
        this.endTime = movie.getEndTime();
        this.hall = movie.getHall();

    }
}
