package com.gruppe1.kinoxp.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gruppe1.kinoxp.schedule.dto.request.WorkDayRequest;
import com.gruppe1.kinoxp.schedule.dto.response.WorkDayResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkDay implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "work_date")
    private LocalDate workDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "work_date")
    private List<WorkTask> workTasks = new ArrayList<>();

    public WorkDay(LocalDate workDate, Employee employee, List<WorkTask> workTasks) {
        this.workDate = workDate;
        this.employee = employee;
        this.workTasks = workTasks;
    }

    public WorkDay(LocalDate workDate, Employee employee) {
        this.workDate = workDate;
        this.employee = employee;
    }

    public WorkDay(WorkDayResponse response, Employee employee) {
        this.workDate = response.getWorkDate();
        this.workTasks = response.getWorkTasks();
        this.employee = employee;
    }

    public void removeTask(LocalTime startTime, LocalTime endTime) {
        for (int i = 0; i < workTasks.size(); i++) {
            if (workTasks.get(i).getStartTime().equals(startTime) && workTasks.get(i).getEndTime().equals(endTime)) {
                workTasks.remove(i);
                return;
            }
        }
    }
}
