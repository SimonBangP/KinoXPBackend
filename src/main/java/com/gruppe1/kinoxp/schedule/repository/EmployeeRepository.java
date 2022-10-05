package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
