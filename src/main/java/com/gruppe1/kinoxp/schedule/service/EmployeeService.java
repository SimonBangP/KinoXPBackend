package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public EmployeeResponse getByFirstAndLastName(String firstName, String lastName) {
        Optional<Employee> optionalEmployee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);

        if (optionalEmployee.isPresent()) {
            return new EmployeeResponse(optionalEmployee.get());
        }
        else {
            return null;
        }
    }

    public List<EmployeeResponse> getEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponse> response = employees.stream().map(employee -> new EmployeeResponse(employee)).collect(Collectors.toList());
        return response;
    }

    public List<Employee> findEmployeeById(int id){
        return employeeRepository.findEmployeeById(id);
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteEmployeeById(id);
    }
}
