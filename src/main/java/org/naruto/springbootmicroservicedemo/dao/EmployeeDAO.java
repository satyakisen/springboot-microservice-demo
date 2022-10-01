package org.naruto.springbootmicroservicedemo.dao;

import org.naruto.springbootmicroservicedemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EmployeeDAO extends CrudRepository<Employee, UUID> {
    List<Employee> findAll();
}
