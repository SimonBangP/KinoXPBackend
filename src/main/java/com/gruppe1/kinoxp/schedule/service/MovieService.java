package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.dto.response.MovieResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import com.gruppe1.kinoxp.schedule.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<MovieResponse> getMovies(){
        List<Movie> movies = movieRepository.findAll();

        List<MovieResponse> responses = movies.stream().map(movie -> new MovieResponse(movie)).collect(Collectors.toList());
        return responses;
    }

    public List<MovieResponse> getAllOnDate(LocalDate date) {

        List<Movie> responses = movieRepository.findByStartTimeBetween(date.atStartOfDay(), date.atStartOfDay().plusHours(23).plusMinutes(59));

        return responses.stream().map(movie -> new MovieResponse(movie)).collect(Collectors.toList());
    }
}
