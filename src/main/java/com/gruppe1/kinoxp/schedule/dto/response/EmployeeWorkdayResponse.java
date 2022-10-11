package com.gruppe1.kinoxp.schedule.dto.response;

import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class EmployeeWorkdayResponse {


        private LocalDate workDate;

        private List<WorkTask> workTasks = new ArrayList<>();

        private NoWorkdayEmployeeResponse employee = new NoWorkdayEmployeeResponse();

        public EmployeeWorkdayResponse(WorkDay workDay) {
            this.workDate = workDay.getWorkDate();
            this.workTasks = workDay.getWorkTasks();
            this.employee = new NoWorkdayEmployeeResponse(workDay.getEmployee());
        }

}
