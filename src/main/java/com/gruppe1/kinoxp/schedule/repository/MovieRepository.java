package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
