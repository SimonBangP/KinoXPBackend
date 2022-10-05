package com.gruppe1.kinoxp.schedule.api;

import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
}
