package com.leo.apirest.services;

import com.leo.apirest.dao.IContractDao;
import com.leo.apirest.dao.IEmployeeDao;
import com.leo.apirest.models.ActiveEmployeeResponse;
import com.leo.apirest.models.Contract;
import com.leo.apirest.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements IEmployee{

    @Autowired
    private IEmployeeDao employeeDao;

    @Autowired
    private IContractDao contractDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.getEmployees();
    }

    //endpoint 1
    @Override
    public List<ActiveEmployeeResponse> findActiveEmployees() {

        List<ActiveEmployeeResponse> activeEmployeeResponses = new ArrayList<>();
        List<Contract> contracts =  contractDao.getContracts();
        for(Contract contract: contracts){
            ActiveEmployeeResponse activeEmployee = new ActiveEmployeeResponse();
            if(contract.getEmployee().getIsActive()){
                activeEmployee.setFullName(contract.getEmployee().getName()+" "+contract.getEmployee().getLastName());
                activeEmployee.setTaxIdNumber(contract.getEmployee().getTextIdNumber());
                activeEmployee.setEmail(contract.getEmployee().getEmail());
                if (contract.getIsActive()){
                    activeEmployee.setContractTypeName(contract.getContractType().getName());
                    activeEmployee.setContractDateFrom(contract.getDateFrom());
                    activeEmployee.setContractDateTo(contract.getDateTo());
                    activeEmployee.setContractSalaryPerDay(contract.getSalaryPerDay());
                }else{
                    activeEmployee.setContractTypeName(null);
                    activeEmployee.setContractDateFrom(null);
                    activeEmployee.setContractDateTo(null);
                    activeEmployee.setContractSalaryPerDay(0.0);
                }
                activeEmployeeResponses.add(activeEmployee);
            }

        }
        return activeEmployeeResponses;
    }

    //endpoint 3
    @Override
    public Employee addEmployee(Employee employee) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Employee> listEmployee = employeeDao.getEmployees();
        if(listEmployee != null){
            for (Employee employee1: listEmployee){
                if(employee1.getTextIdNumber().equals(employee.getTextIdNumber())){
                    return null;
                }
            }
        }
        if(!employee.getTextIdNumber().toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}")){
            Employee employeeInvalid = employee;
            employeeInvalid.setTextIdNumber("invalid");
            return employeeInvalid;
        }
        employee.setDateCreated(dtf.format(LocalDateTime.now()));
        employeeDao.addEmployee(employee);
        return employee;
    }

    //endpoint 4
    @Override
    public Employee updateEmployee(Employee employee) {
        List<Employee> listEmployee = employeeDao.getEmployees();
        if(listEmployee != null){
            for (Employee employee1: listEmployee){
                if(employee1.getTextIdNumber().equals(employee.getTextIdNumber())){
                    return null;
                }
            }
        }
        if(!employee.getTextIdNumber().toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}")){
            Employee employeeInvalid = employee;
            employeeInvalid.setTextIdNumber("invalid");
            return employeeInvalid;
        }
        employeeDao.addEmployee(employee);
        return employee;
    }
}
