package com.gruppe1.kinoxp.schedule.api;

import com.gruppe1.kinoxp.schedule.dto.request.EmployeeRequest;
import com.gruppe1.kinoxp.schedule.dto.response.EmployeeResponse;
import com.gruppe1.kinoxp.schedule.entity.Employee;
import com.gruppe1.kinoxp.schedule.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @Operation(summary = "Gets a list of all employees", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    // This might not be optimal as the url is not a fan of spaces
    @Operation(summary = "Gets an employee by full name", responses = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content())})
    @GetMapping("/{name}")
    public ResponseEntity<EmployeeResponse> getEmployeeByName(@PathVariable String name) {
        String[] nameParts = name.split(" ");

        String firstName = getFirstNameFromNameParts(nameParts);
        String lastName = nameParts[nameParts.length-1];

        EmployeeResponse foundEmployee = employeeService.getByFirstAndLastName(firstName, lastName);
        if (foundEmployee != null) {
            return new ResponseEntity<>(foundEmployee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Adds a new employee", responses = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeRequest request) {
        Employee newEmployee = new Employee(request);

        employeeService.add(newEmployee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Removes an employee from the database", responses = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404", content = @Content())})
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> removeEmployee(@PathVariable String name) {
        String[] nameParts = name.split(" ");

        String firstName = getFirstNameFromNameParts(nameParts);
        String lastName = nameParts[nameParts.length-1];

        EmployeeResponse foundEmployee = employeeService.getByFirstAndLastName(firstName, lastName);
        if (foundEmployee != null) {
            employeeService.deleteEmployeeById(foundEmployee.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
