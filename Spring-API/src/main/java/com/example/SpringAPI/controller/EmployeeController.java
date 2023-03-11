package com.example.SpringAPI.controller;

import com.example.SpringAPI.exception.ResourseNotFoundException;
import com.example.SpringAPI.model.Employee;
import com.example.SpringAPI.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new ResourseNotFoundException("Employee exist with id:" + id));
        return  ResponseEntity.ok(employee);
    }



}
