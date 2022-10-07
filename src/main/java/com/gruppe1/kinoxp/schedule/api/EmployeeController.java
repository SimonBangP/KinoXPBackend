package com.gruppe1.kinoxp.schedule.api;

import com.gruppe1.kinoxp.schedule.dto.request.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public List<EmployeeResponse> getEmployees(){
        return employeeService.getEmployees();
    }
}
