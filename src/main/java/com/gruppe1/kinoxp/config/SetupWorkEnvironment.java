package com.gruppe1.kinoxp.config;

import com.gruppe1.kinoxp.schedule.entity.*;
import com.gruppe1.kinoxp.schedule.repository.TaskNameRepository;
import com.gruppe1.kinoxp.schedule.repository.WorkTaskRepository;
import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import com.gruppe1.kinoxp.schedule.service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Component
public class SetupWorkEnvironment implements ApplicationRunner {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TaskNameService taskNameService;
    @Autowired
    TaskNameRepository taskNameRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Employee testEmployee = new Employee("Sebastian", "Rasmussen", "test@mail.dk", "29870788", "Christiansvej 11", "2600 Glostrup", Role.BOSS);
        //employeeService.add(testEmployee);

        //Employee testEmployee = employeeService.getByFirstAndLastName("Sebastian", "Rasmussen");

        TaskName taskName = new TaskName("Billet salg");
        taskNameService.add(taskName);
        //TaskName taskName = taskNameService.getByName("Billet salg");

        List<WorkTask> workTasks = new ArrayList<>();
        //workTaskService.addRange(workTasks);

        WorkDay workDay = new WorkDay(LocalDate.now(), testEmployee, workTasks);
        //workDayService.add(workDay);
        testEmployee.getWorkDays().add(workDay);

        WorkTask task = new WorkTask(taskName, "Stå for billetsalg for sal 4", LocalTime.of(10, 10, 10), LocalTime.of(12,12,12));
        workTasks.add(task);
        testEmployee.getWorkDays().get(0).setWorkTasks(workTasks);

        employeeService.add(testEmployee);
        testEmployee = new Employee(employeeService.getByFirstAndLastName("Sebastian", "Rasmussen"));

        List<WorkDay> workDays = testEmployee.getWorkDays();

        System.out.println(workDays.size());
        System.out.println(workDays.get(0).getWorkTasks().size());
        System.out.println(workDays.get(0).getWorkTasks().get(0).getWorkDay() == null);

        TaskName slikSalg = TaskName.builder()
                .taskName("Sliksalg")
                .build();

        TaskName rengøring = TaskName.builder()
                .taskName("Rengøring")
                .build();

        TaskName oprydning = TaskName.builder()
                .taskName("Oprydning")
                .build();

        taskNameRepository.save(slikSalg);
        taskNameRepository.save(rengøring);
        taskNameRepository.save(oprydning);

    }
}
