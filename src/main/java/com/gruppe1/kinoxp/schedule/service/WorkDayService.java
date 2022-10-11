package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.dto.response.EmployeeWorkdayResponse;
import com.gruppe1.kinoxp.schedule.dto.response.WorkDayResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import com.gruppe1.kinoxp.schedule.repository.WorkDayRepository;
import com.gruppe1.kinoxp.schedule.repository.WorkTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkDayService {

    @Autowired
    WorkDayRepository workDayRepository;

    @Autowired
    WorkTaskRepository workTaskRepository;

    public void add(WorkDay workDay) {
        workDayRepository.save(workDay);
    }

    public List<EmployeeWorkdayResponse> findByDate(LocalDate date) {
        List<WorkDay> workDays = workDayRepository.findByWorkDate(date);

        return workDays.stream().map(workday -> new EmployeeWorkdayResponse(workday)).collect(Collectors.toList());

    }

    public WorkDayResponse findByDateAndEmployee(LocalDate date, Employee employee) {
        Optional<WorkDay> optionalWorkDay = workDayRepository.findByWorkDateAndEmployee(date, employee);

        if (optionalWorkDay.isPresent()) {
            return new WorkDayResponse(optionalWorkDay.get());
        }
        else {
            return null;
        }
    }

    public List<WorkDayResponse> getAllWorkDaysByEmployee(Employee employee) {
        return employee.getWorkDays().stream().map(workday -> new WorkDayResponse(workday)).collect(Collectors.toList());
    }

    public List<WorkDay> findDaysBetween(LocalDate startDate, LocalDate endDate) {
        return workDayRepository.findByWorkDateIsBetween(startDate, endDate);
    }

    public void addWorkTaskToWorkDay(WorkTask task, WorkDay day) {
        day.getWorkTasks().add(task);
        workDayRepository.save(day);
    }

}
