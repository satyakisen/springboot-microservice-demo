package org.naruto.springbootmicroservicedemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

/**
 * The type Employee.
 */
public class Employee implements Serializable {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dept")
    private String dept;
    @JsonProperty("salary")
    private double salary;

    /**
     * Instantiates a new Employee.
     */
    public Employee() {
        this.id = null;
        this.name = null;
        this.dept = null;
        this.salary = Double.MIN_VALUE;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param id     the id
     * @param name   the name
     * @param dept   the dept
     * @param salary the salary
     */
    public Employee(UUID id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets dept.
     *
     * @return the dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * Sets dept.
     *
     * @param dept the dept
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
