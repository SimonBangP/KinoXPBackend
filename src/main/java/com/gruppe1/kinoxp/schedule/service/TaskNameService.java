package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.request.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.dto.request.TaskNameResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.repository.TaskNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskNameService {

    @Autowired
    TaskNameRepository taskNameRepository;

    public void add(TaskName taskName) {
        taskNameRepository.save(taskName);
    }

    public TaskName getByName(String taskName) {
        Optional<TaskName> optionalTaskName = taskNameRepository.findByTaskName(taskName);

        if (optionalTaskName.isPresent()) {
            return optionalTaskName.get();
        }
        else {
            return null;
        }
    }

    public List<TaskNameResponse> getTaskName (){
        List<TaskName> taskNames = taskNameRepository.findAll();
        System.out.println(taskNames);

        List<TaskNameResponse> response = taskNames.stream().map(taskName -> new TaskNameResponse(taskName)).collect(Collectors.toList());
        return response;



     /*   List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponse> response = employees.stream().map(employee -> new EmployeeResponse(employee)).collect(Collectors.toList());
        return response;*/

    }

}
