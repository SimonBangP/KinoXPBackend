package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkDayRepository extends JpaRepository<WorkDay, Integer> {

    List<WorkDay> findByWorkDate(LocalDate workDate);

    Optional<WorkDay> findByWorkDateAndEmployee(LocalDate workDate, Employee employee);

    List<WorkDay> findByWorkDateIsBetween(LocalDate workDateStart, LocalDate workDateEnd);

}
