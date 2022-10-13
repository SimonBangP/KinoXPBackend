package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.response.HallResponse;
import com.gruppe1.kinoxp.schedule.dto.response.MovieResponse;
import com.gruppe1.kinoxp.schedule.entity.Hall;
import com.gruppe1.kinoxp.schedule.entity.Movie;
import com.gruppe1.kinoxp.schedule.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallService {

    @Autowired
    HallRepository hallRepository;

    public List<HallResponse> getHalls(){
        List<Hall> halls = hallRepository.findAll();

        List<HallResponse> responses = halls.stream().map(hall -> new HallResponse(hall)).collect(Collectors.toList());
        return responses;
    }
}
