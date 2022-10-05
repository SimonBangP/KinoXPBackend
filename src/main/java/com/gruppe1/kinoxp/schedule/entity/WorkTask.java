package com.gruppe1.kinoxp.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import java.time.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Eager
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Period taskPeriod;

    private String description;

    @ManyToOne
    @JoinColumn(name = "name_id")
    private TaskName name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_date", insertable = false, updatable = false)
    private WorkDay workDay;


    public WorkTask(Period taskPeriod, TaskName name, String description) {
        this.taskPeriod = taskPeriod;
        this.name = name;
        this.description = description;
    }
}
