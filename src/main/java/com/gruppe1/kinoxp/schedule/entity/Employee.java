package com.gruppe1.kinoxp.schedule.entity;

import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String address;
    private String city;
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WorkDay> workDays = new ArrayList<>();

    // Vi kan ikke have @AllArgsConstructor når id er autogenereret
    public Employee(String firstName, String lastName, String email, int phoneNumber, String address, String city, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.role = role;
    }


}
