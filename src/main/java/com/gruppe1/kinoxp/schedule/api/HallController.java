package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.response.HallResponse;
import com.gruppe1.kinoxp.schedule.service.HallService;
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
@RestController
@RequestMapping("api/v1/halls")
@CrossOrigin
public class HallController {



    @Autowired
    HallService hallService;
    @GetMapping
    public ResponseEntity<List<HallResponse>> getHalls(){
        return new ResponseEntity<>(hallService.getHalls(), HttpStatus.OK);
    }
}
