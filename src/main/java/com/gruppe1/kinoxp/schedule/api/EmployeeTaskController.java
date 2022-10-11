package com.gruppe1.kinoxp.schedule.api;

import com.gruppe1.kinoxp.schedule.dto.request.WorkDayRequest;
import com.gruppe1.kinoxp.schedule.dto.request.worktask.WorkTaskRemoveRequest;
import com.gruppe1.kinoxp.schedule.dto.request.worktask.WorkTaskRequest;
import com.gruppe1.kinoxp.schedule.dto.response.WorkDayResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("api/v1/workdays")
@RestController
@CrossOrigin
public class EmployeeTaskController {

    @Autowired
    WorkDayService workDayService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    TaskNameService taskNameService;

    @Operation(summary = "Gets all assigned work tasks for current date", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping
    public ResponseEntity<List<WorkDayResponse>> getAllWorkAssignmentForCurrentDate() {

         return new ResponseEntity<>(workDayService.findByDate(LocalDate.now()), HttpStatus.OK);
    }

    @Operation(summary = "Gets all workdays from employee by full name", responses = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content())})
    @GetMapping("/{employeeName}")
    public ResponseEntity<List<WorkDayResponse>> getAllEmployeeWorkdays(@PathVariable String employeeName) {
        Employee foundEmployee = getEmployeeByFullName(employeeName);

        if (foundEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(workDayService.getAllWorkDaysByEmployee(foundEmployee), HttpStatus.OK);
    }

    @Operation(summary = "Adds a new workday to an employee", responses = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404")})
    @PostMapping
    public ResponseEntity<Void> addNewWorkDay(@RequestBody WorkDayRequest request) {
        Employee foundEmployee = getEmployeeByFullName(request.getEmployeeFullName());

        if (foundEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        WorkDay workDay = new WorkDay(request.getWorkDate(), foundEmployee);
        foundEmployee.getWorkDays().add(workDay);
        employeeService.add(foundEmployee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Remove work day from employee", responses = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @DeleteMapping
    public ResponseEntity<Void> removeWorkDayForEmployee(@RequestBody WorkDayRequest request) {
        Employee foundEmployee = getEmployeeByFullName(request.getEmployeeFullName());

        if (foundEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        foundEmployee.removeWorkDay(request.getWorkDate());
        employeeService.add(foundEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Adds a task to an employee", responses = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404")})
    @PostMapping("/tasks")
    public ResponseEntity<Void> addNewTaskToWorkDay(@RequestBody WorkTaskRequest request) {
        Employee foundEmployee = getEmployeeByFullName(request.getWorkDayRequest().getEmployeeFullName());

        if (foundEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        TaskName taskName = taskNameService.getByName(request.getTaskName());

        if (taskName == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        WorkDayResponse response = workDayService.findByDateAndEmployee(request.getWorkDayRequest().getWorkDate(), foundEmployee);

        WorkTask task = new WorkTask(request, taskName);

        WorkDay workDay = new WorkDay(response, foundEmployee);
        workDay.getWorkTasks().add(task);

        employeeService.add(foundEmployee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Remove task from day from employee", responses = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @DeleteMapping("/tasks")
    public ResponseEntity<Void> removeTaskFromWorkDay(@RequestBody WorkTaskRemoveRequest request) {
        Employee foundEmployee = getEmployeeByFullName(request.getWorkDayRequest().getEmployeeFullName());

        if (foundEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        foundEmployee.getWorkDay(request.getWorkDayRequest().getWorkDate()).removeTask(request.getStartTime(), request.getEndTime());
        employeeService.add(foundEmployee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Employee getEmployeeByFullName(String fullName) {
        String[] nameParts = fullName.split(" ");
        String firstName = getFirstNameFromNameParts(nameParts);
        String lastName = nameParts[nameParts.length-1];

        Employee foundEmployee = new Employee(employeeService.getByFirstAndLastName(firstName, lastName));
        return foundEmployee;
    }

    private String getFirstNameFromNameParts(String[] nameParts) {
        String firstName = "";
        for (int i = 0; i < nameParts.length-1; i++) {
            if (i != nameParts.length-2) {
                firstName += nameParts[i] + " ";
            }
            else {
                firstName += nameParts[i];
            }
        }
        return firstName;
    }
}
