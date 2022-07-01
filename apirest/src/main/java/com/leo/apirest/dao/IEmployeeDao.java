package com.leo.apirest.dao;

import com.leo.apirest.models.Employee;

import java.util.List;

public interface IEmployeeDao {
    List<Employee> getEmployees();
    Employee getEmployeeById(Integer id);
    void addEmployee(Employee employee);
}
