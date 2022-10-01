package org.naruto.springbootmicroservicedemo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @MockBean
    private EmployeeService mockEmpSvc;
    @Autowired
    private MockMvc mockMvc;

    private List<Employee> employees;
    private String id;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID().toString();
        employees = new ArrayList<>();
        Employee employee = new Employee(UUID.fromString(id), "Naruto Uzumaki", "Marketing", 250000.00);
        employees.add(employee);
    }

    @Test
    void shouldGetEmployees() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/v1/employee/list"))
                .andExpect(status().isOk()).andReturn();
        when(mockEmpSvc.getEmployees()).thenReturn(employees);
        Assertions.assertTrue(mvcResult.getResponse().getContentAsString().length() > 0);
    }

}