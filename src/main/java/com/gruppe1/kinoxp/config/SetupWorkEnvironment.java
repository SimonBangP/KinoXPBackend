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
        Employee testEmployee = new Employee("Sebastian", "Rasmussen", "test@mail.dk", "29870788", "Bånderøvsvej 11", "2600 Salgelse", Role.Piccoline);
        Employee testEmployee2 = new Employee("Ömer", "Mert", "test2@mail.dk", "29840788", "Ömersvej 1", "8000 Aarhus", Role.Boss);
        Employee testEmployee3 = new Employee("Simon", "Bang", "test3@mail.dk", "29875788", "Simonsvej 11", "2600 Glostrup", Role.Piccoline);
        Employee testEmployee4 = new Employee("Lukas", "Nielsen", "test4@mail.dk", "29870789", "Lukassvej 11", "1000 ??", Role.Piccoline);
        employeeService.add(testEmployee);
        employeeService.add(testEmployee2);
        employeeService.add(testEmployee3);
        employeeService.add(testEmployee4);


        List<WorkTask> workTasks = new ArrayList<>();
        List<WorkTask> workTasks2 = new ArrayList<>();
        List<WorkTask> workTasks3 = new ArrayList<>();
        List<WorkTask> workTasks4 = new ArrayList<>();


        WorkDay workDay = new WorkDay(LocalDate.now(), testEmployee, workTasks);
        testEmployee.getWorkDays().add(workDay);

        WorkDay workDay2 = new WorkDay(LocalDate.now(), testEmployee2, workTasks2);
        testEmployee2.getWorkDays().add(workDay2);

        WorkDay workDay3 = new WorkDay(LocalDate.now(), testEmployee3, workTasks3);
        testEmployee3.getWorkDays().add(workDay3);

        WorkDay workDay4 = new WorkDay(LocalDate.now(), testEmployee4, workTasks4);
        testEmployee4.getWorkDays().add(workDay4);



        TaskName billetSalg = new TaskName("Billet salg");
        taskNameService.add(billetSalg);

        WorkTask task = new WorkTask(billetSalg, "Stå for billetsalg for sal 4", LocalTime.of(10, 0, 0), LocalTime.of(12,30,12));
        workTasks.add(task);
        testEmployee.getWorkDays().get(0).setWorkTasks(workTasks);


        TaskName checkop = new TaskName("Check op");
        taskNameService.add(checkop);

        WorkTask task2 = new WorkTask(checkop, "Check op på medarbejderne og giv feedback", LocalTime.of(12, 0, 0), LocalTime.of(14,0,0));
        workTasks2.add(task2);
        testEmployee2.getWorkDays().get(0).setWorkTasks(workTasks2);


        TaskName popcorn = new TaskName("Lav popcorn");
        taskNameService.add(popcorn);

        WorkTask task3 = new WorkTask(popcorn, "Smid popcorn ud hvis det er for gammelt, og lav ny hvis nødvendigt", LocalTime.of(8, 0, 0), LocalTime.of(10,30,0));
        workTasks3.add(task3);
        testEmployee3.getWorkDays().get(0).setWorkTasks(workTasks3);


        TaskName toilet = new TaskName("Rengør Toilet");
        taskNameService.add(toilet);

        WorkTask task4 = new WorkTask(toilet, "Rengør toilettet grundigt", LocalTime.of(14, 0, 0), LocalTime.of(15,45,0));
        workTasks4.add(task4);
        testEmployee4.getWorkDays().get(0).setWorkTasks(workTasks4);



        employeeService.add(testEmployee);
        employeeService.add(testEmployee2);
        employeeService.add(testEmployee3);
        employeeService.add(testEmployee4);
        testEmployee = new Employee(employeeService.getByFirstAndLastName("Sebastian", "Rasmussen"));
        testEmployee2 = new Employee(employeeService.getByFirstAndLastName("Ömer", "Mert"));
        testEmployee3 = new Employee(employeeService.getByFirstAndLastName("Simon", "Bang"));
        testEmployee4 = new Employee(employeeService.getByFirstAndLastName("Lukas", "Nielsen"));


        List<WorkDay> workDays = testEmployee.getWorkDays();
        List<WorkDay> workDays2 = testEmployee2.getWorkDays();
        List<WorkDay> workDays3 = testEmployee3.getWorkDays();
        List<WorkDay> workDays4 = testEmployee4.getWorkDays();



        taskNameRepository.save(toilet);
        taskNameRepository.save(checkop);
        taskNameRepository.save(popcorn);
        taskNameRepository.save(billetSalg);
    }
}
