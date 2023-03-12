package com.example.SpringAPI.controller;

import com.example.SpringAPI.exception.ResourseNotFoundException;
import com.example.SpringAPI.model.Employee;
import com.example.SpringAPI.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    //Get employee API
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    //Save employee API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new ResourseNotFoundException("Employee exist with id:" + id));
        return  ResponseEntity.ok(employee);
    }

    //Update employee API
    @PutMapping ("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepo.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //Delete Employee API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id: " + id));
        employeeRepo.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
