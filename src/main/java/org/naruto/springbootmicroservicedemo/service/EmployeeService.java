package org.naruto.springbootmicroservicedemo.service;

import org.naruto.springbootmicroservicedemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
}
