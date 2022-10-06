package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findEmployeeById(int id);

    void deleteEmployeeById(int id);
}
