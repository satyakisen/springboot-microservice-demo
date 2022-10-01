package org.naruto.springbootmicroservicedemo.service.impl;

import org.naruto.springbootmicroservicedemo.dao.EmployeeDAO;
import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        if (employees == null || employees.size() == 0) {
            throw new RuntimeException("There are no employees.");
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public Employee createEmployee(Employee emp) {
        return null;
    }

    @Override
    public void updateEmployee(Employee emp) {

    }

    @Override
    public void deleteEmployee(String id) {

    }
}
