package org.naruto.springbootmicroservicedemo.controller;

import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService empService;

    /**
     * Instantiates a new Employee controller.
     *
     * @param empService the emp service
     */
    @Autowired
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    /**
     * Get employee list response entity.
     *
     * @return the response entity
     */
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getEmployeeList(){
        List<Employee> employees = empService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
        return ResponseEntity.ok(empService.getEmployeeById(id));
    }

    /**
     * Create employee response entity.
     * @param employee the employee
     * @return the response entity
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee emp = new Employee(UUID.randomUUID(), employee.getName(), employee.getDept(), employee.getSalary());
        return new ResponseEntity<>(empService.createEmployee(emp), HttpStatus.CREATED);
    }

}
