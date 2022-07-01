package com.leo.apirest.services;

import com.leo.apirest.models.ActiveEmployeeResponse;
import com.leo.apirest.models.Employee;

import java.util.List;

public interface IEmployee {
    List<Employee> findAll();
    List<ActiveEmployeeResponse> findActiveEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
}
