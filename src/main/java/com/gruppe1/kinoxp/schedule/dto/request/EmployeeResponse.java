package com.gruppe1.kinoxp.schedule.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.Role;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

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


    public EmployeeResponse(int id, String firstName, String lastName, String email, int phoneNumber, String address, String city, Role role, List<WorkDay> workDays) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.role = role;
        this.workDays = workDays;
    }

   public EmployeeResponse(Employee employees) {
        this.id = employees.getId();
        this.firstName = employees.getFirstName();
        this.lastName = employees.getLastName();
        this.email = employees.getEmail();
        this.phoneNumber = employees.getPhoneNumber();
        this.address = employees.getAddress();
        this.city = employees.getCity();
        this.role = employees.getRole();
        this.workDays = employees.getWorkDays();
   }
}
