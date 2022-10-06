package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.*;
import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TaskNameRepository taskNameRepository;

    @Autowired
    WorkDayRepository workDayRepository;

    @BeforeEach
    void setUpBeforeEach(){
        Employee testEmployee = new Employee("Sebastian", "Rasmussen", "test@mail.dk", 29870788, "Christiansvej 11", "2600 Glostrup", Role.PICCOLINE);

        TaskName taskName = new TaskName("Billet salg");
        taskNameRepository.save(taskName);

        List<WorkTask> workTasks = new ArrayList<>();

        WorkTask task = new WorkTask(Period.of(0, 0, 1), taskName, "Stå for billetsalg for sal 4");

        workTasks.add(task);

        WorkDay workDay = new WorkDay(LocalDate.now(), testEmployee, workTasks);

        testEmployee.getWorkDays().add(workDay);

        employeeRepository.save(testEmployee);

    }

    @Test
    public void createEmpolyee(){
        Employee testEmployee = new Employee("Ömer", "Rasmussen", "test@mail.dk", 29870788, "Christiansvej 11", "2600 Glostrup", Role.BOSS);
        employeeRepository.save(testEmployee);

        assertEquals(2, employeeRepository.count());

    }

    @Test
    public void findEmployeeById() {
        List<Employee> employees = employeeRepository.findEmployeeById(1);

        assertEquals(1, employees.size());
    }

    @Test
    public void findByFirstNameAndLastName(){
        Optional<Employee> employees = employeeRepository.findByFirstNameAndLastName("Sebastian", "Rasmussen");

        assertEquals(false, employees.isEmpty());
    }


    @Test
    public void editEmployee(){
        Optional<Employee> employees = employeeRepository.findByFirstNameAndLastName("Sebastian", "Rasmussen");

        employees.get().setLastName("mert");

        Optional<Employee> employes = employeeRepository.findByFirstNameAndLastName("Sebastian", "mert");

        assertEquals(false, employes.isEmpty());
        assertEquals("mert", employees.get().getLastName());
    }

    @Test
    public void deleteEmployee(){
        employeeRepository.deleteEmployeeById(1);

        List<WorkDay> workDays = workDayRepository.findAll();
        List<Employee> employees = employeeRepository.findEmployeeById(1);

        assertEquals(0, workDays.size());
        assertEquals(0, employees.size());
    }
}