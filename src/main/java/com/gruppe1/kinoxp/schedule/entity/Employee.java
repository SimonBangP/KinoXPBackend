package com.gruppe1.kinoxp.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id int id;
    String firstName;
    String lastName;
    String email;
    int phoneNumber;
    String address;
    String city;
    Role role;

    @OneToMany(mappedBy = "name", fetch = FetchType.LAZY)
    List<WorkTask> workTasks = new ArrayList<>();
}
