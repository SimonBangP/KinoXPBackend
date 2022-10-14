package com.gruppe1.kinoxp.schedule.dto.response;

import com.gruppe1.kinoxp.schedule.entity.Genre;
import com.gruppe1.kinoxp.schedule.entity.Hall;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    private LocalDateTime movieStartTime;

    private LocalDateTime movieEndTime;

    LocalDateTime advertisementStartTime;

    LocalDateTime cleaning;

    Hall hall;

    public MovieResponse(Movie movie){
        this.name = movie.getName();
        this.description = (movie.getDescription());
        this.hours = movie.getHours();
        this.minutes = movie.getMinutes();
        this.genres = movie.getGenres();
        this.advertisementStartTime = movie.getAdvertisementStartTime();
        this.movieStartTime = advertisementStartTime.plusMinutes(20);
        this.movieEndTime = movieStartTime.plusHours(hours).plusMinutes(minutes);
        this.cleaning = movieEndTime.plusMinutes(30);
        this.hall = movie.getHall();

    }
}
