package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.dto.response.HallResponse;
import com.gruppe1.kinoxp.schedule.dto.response.MovieResponse;
import com.gruppe1.kinoxp.schedule.service.HallService;
import com.gruppe1.kinoxp.schedule.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("api/v1/halls")
@CrossOrigin
public class HallController {



    @Autowired
    HallService hallService;

    @Autowired
    MovieService movieService;
    @GetMapping
    public ResponseEntity<List<HallResponse>> getHalls(){
        return new ResponseEntity<>(hallService.getHalls(), HttpStatus.OK);
    }
}
