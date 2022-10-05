package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.repository.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkDayService {

    @Autowired
    WorkDayRepository workDayRepository;

    public void add(WorkDay workDay) {
        workDayRepository.save(workDay);
    }

    public WorkDay findByDate(LocalDate date) {
        Optional<WorkDay> optionalWorkDay = workDayRepository.findById(date);

        if (optionalWorkDay.isPresent()) {
            return optionalWorkDay.get();
        }
        else {
            return null;
        }
    }

    public List<WorkDay> findDaysBetween(LocalDate startDate, LocalDate endDate) {
        return workDayRepository.findByWorkDateIsBetween(startDate, endDate);
    }

}
