package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.response.MovieResponse;
import com.gruppe1.kinoxp.schedule.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/movies")
@RestController
@CrossOrigin
public class MovieController {

    @Autowired
    MovieService movieService;

    @Operation(summary = "Gets a list of all movies", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping
    public ResponseEntity<List<MovieResponse>> getmovies(){
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }
}
