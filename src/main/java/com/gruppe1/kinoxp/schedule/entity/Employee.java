package com.gruppe1.kinoxp.schedule.entity;

import com.gruppe1.kinoxp.schedule.dto.request.EmployeeRequest;
import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
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
    private String phoneNumber;
    private String address;
    private String city;
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<WorkDay> workDays = new ArrayList<>();

    // Vi kan ikke have @AllArgsConstructor når id er autogenereret
    public Employee(String firstName, String lastName, String email, String phoneNumber, String address, String city, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.role = role;
    }

    public Employee(EmployeeResponse employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.city = employee.getCity();
        this.role = employee.getRole();
        this.workDays = employee.getWorkDays();
    }

    public Employee(EmployeeRequest employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.city = employee.getCity();
        this.role = employee.getRole();
    }

    public void removeWorkDay(LocalDate date) {
        for (int i = 0; i < workDays.size(); i++) {
            if (workDays.get(i).getWorkDate().equals(date)) {
                workDays.remove(i);
                return;
            }
        }
    }

    public WorkDay getWorkDay(LocalDate date) {
        for (int i = 0; i < workDays.size(); i++) {
            if (workDays.get(i).getWorkDate().equals(date)) {
                return workDays.get(i);
            }
        }
        return null;
    }
}
