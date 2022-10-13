package com.gruppe1.kinoxp.schedule.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gruppe1.kinoxp.schedule.entity.Hall;
import com.gruppe1.kinoxp.schedule.entity.HallSize;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HallResponse {


    int hallNumber;

    int seats;

    HallSize hallSize;

    @OneToMany(mappedBy = "hall", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Movie> movies = new ArrayList<>();


    public HallResponse(Hall hall){
        this.hallNumber = hall.getHallNumber();
        this.seats = hall.getSeats();
        this.hallSize = hall.getHallSize();
        this.movies = hall.getMovies();
    }
}
