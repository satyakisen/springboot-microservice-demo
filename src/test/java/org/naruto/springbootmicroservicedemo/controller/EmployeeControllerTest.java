package org.naruto.springbootmicroservicedemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.naruto.springbootmicroservicedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    @MockBean
    private EmployeeService mockEmpSvc;
    @Autowired
    private MockMvc mockMvc;

    private List<Employee> employees;
    private String id;
    private Employee employee;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID().toString();
        employees = new ArrayList<>();
        employee = new Employee(UUID.fromString(id), "Naruto Uzumaki", "Marketing", 250000.00);
        employees.add(employee);
    }

    @Test
    void shouldGetEmployees() throws Exception {
        when(mockEmpSvc.getEmployees()).thenReturn(employees);
        mockMvc.perform(get("/v1/employee/list"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    void shouldGetEmployeeById() throws Exception {
        when(mockEmpSvc.getEmployeeById(anyString())).thenReturn(employee);
        mockMvc.perform(get("/v1/employee/" + id).accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(id)));
    }

    @Test
    void shouldCreateAnEmployee() throws Exception {
        when(mockEmpSvc.createEmployee(any())).thenReturn(employee);
        mockMvc.perform(post("/v1/employee/")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(new ObjectMapper().writeValueAsBytes(employee)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.length()", greaterThan(0)));
    }
}