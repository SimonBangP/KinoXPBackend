package com.gruppe1.kinoxp.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gruppe1.kinoxp.schedule.dto.request.worktask.WorkTaskRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime startTime;
    private LocalTime endTime;

    private String description;

    @ManyToOne
    @JoinColumn(name = "name_id")
    private TaskName name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_date_id", insertable = false, updatable = false)
    @JsonBackReference
    private WorkDay workDay;


    public WorkTask(TaskName name, String description, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public WorkTask(WorkTaskRequest request, TaskName taskName) {
        this.startTime = request.getStartTime();
        this.endTime = request.getEndTime();
        this.name = taskName;
        this.description = request.getDescription();
    }

    public Duration getTaskDuration() {
        return Duration.between(this.startTime, this.endTime);
    }


}
