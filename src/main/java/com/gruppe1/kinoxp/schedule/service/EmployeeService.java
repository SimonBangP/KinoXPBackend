package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    WorkDayService workDayService;

    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        else {
            return null;
        }
    }

    public Employee getByFirstAndLastName(String firstName, String lastName) {
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        else {
            return null;
        }
    }


}
