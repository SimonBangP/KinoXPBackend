package com.gruppe1.kinoxp.schedule.dto.request;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class WorkDayRequest {

    private LocalDate workDate;

    private String employeeFullName;
}
