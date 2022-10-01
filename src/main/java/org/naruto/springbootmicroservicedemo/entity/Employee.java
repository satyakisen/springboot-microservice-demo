package org.naruto.springbootmicroservicedemo.entity;

import java.io.Serializable;
import java.util.UUID;

public class Employee implements Serializable {
    private UUID id;
    private String name;
    private String dept;
    private double salary;

    public Employee() {
        this.id = null;
        this.name = null;
        this.dept = null;
        this.salary = Double.MIN_VALUE;
    }

    public Employee(UUID id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
