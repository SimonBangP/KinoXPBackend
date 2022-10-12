package com.gruppe1.kinoxp.schedule.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
public class WorkTaskResponse {

    private int id;

    private LocalTime startTime;
    private LocalTime endTime;

    private Duration duration;

    private String description;

    private String taskName;

    @JsonBackReference
    private WorkDay workDay;

    public WorkTaskResponse(WorkTask workTask) {
        this.id = workTask.getId();;
        this.startTime = workTask.getStartTime();
        this.endTime = workTask.getEndTime();
        this.duration = workTask.getTaskDuration();
        this.description = workTask.getDescription();
        this.taskName = workTask.getName().getTaskName();
        this.workDay = workTask.getWorkDay();
    }
}
