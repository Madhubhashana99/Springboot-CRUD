package com.example.SpringAPI.repo;

import com.example.SpringAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //All crud database methods

}
