package org.naruto.springbootmicroservicedemo.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.naruto.springbootmicroservicedemo.dao.EmployeeDAO;
import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    @MockBean
    private EmployeeDAO employeeDAO;

    private EmployeeService employeeService;

    private Employee employee;
    private List<Employee> employees;
    private String id;


    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl(employeeDAO);

        id = UUID.randomUUID().toString();
        employee = new Employee(UUID.fromString(id), "Naruto Uzumaki", "Marketing", 250000.00);        employees = new ArrayList<>();
        employees.add(employee);
    }

    @Test
    void shouldGetEmployees() {
        when(employeeDAO.findAll()).thenReturn(employees);
        List<Employee> employees = employeeService.getEmployees();
        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.size() > 0);
    }

    @Test
    void shouldReturnExceptionWhileGettingEmployees() {
        RuntimeException runtimeException =
                Assertions.assertThrows(RuntimeException.class, employeeService::getEmployees);
        Assertions.assertTrue(runtimeException.getMessage().contains("no employees"));
    }
}