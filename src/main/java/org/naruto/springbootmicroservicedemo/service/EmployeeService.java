package org.naruto.springbootmicroservicedemo.service;

import org.naruto.springbootmicroservicedemo.entity.Employee;

import java.util.List;

/**
 * The interface Employee service.
 */
public interface EmployeeService {
    /**
     * Gets employees.
     *
     * @return the employees
     */
    List<Employee> getEmployees();

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    Employee getEmployeeById(String id);

    /**
     * Create employee employee.
     *
     * @param emp the emp
     * @return the employee
     */
    Employee createEmployee(Employee emp);

    /**
     * Update employee.
     *
     * @param emp the emp
     */
    void updateEmployee(Employee emp);

    /**
     * Delete employee.
     *
     * @param id the id
     */
    void deleteEmployee(String id);
}
