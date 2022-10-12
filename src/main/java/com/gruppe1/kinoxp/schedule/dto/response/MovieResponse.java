package com.gruppe1.kinoxp.schedule.dto.response;

import com.gruppe1.kinoxp.schedule.entity.Genre;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponse {

    int id;

    String name;

    String description;

    double length;

    Genre genres;

    public MovieResponse(Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.description = movie.getDescription();
        this.length = movie.getLength();
        this.genres = movie.getGenres();
    }
}
