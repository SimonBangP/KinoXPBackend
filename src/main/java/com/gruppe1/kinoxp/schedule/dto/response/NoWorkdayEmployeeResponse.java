package com.gruppe1.kinoxp.schedule.dto.response;

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
public class NoWorkdayEmployeeResponse {

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

    public NoWorkdayEmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.city = employee.getCity();
        this.role = employee.getRole();
    }
}
