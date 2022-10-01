package org.naruto.springbootmicroservicedemo.controller;

import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService empService;

    @Autowired
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getEmployeeList(){
        List<Employee> employees = empService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }



}
