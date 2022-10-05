package com.gruppe1.kinoxp.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkTask {
    @ManyToOne
    Employee employee;
    @Id
    int id;

    String name;
    String description;
}
