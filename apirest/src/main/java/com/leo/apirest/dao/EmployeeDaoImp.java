package com.leo.apirest.dao;

import com.leo.apirest.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImp implements IEmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    //se usa en el endpoint3 y enpoint 4
    @Override
    public List<Employee> getEmployees() {
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        String query = "FROM Employee WHERE idEmployee ="+id;
        return (Employee) entityManager.createQuery(query).getSingleResult();
    }

    //se usa en el endpoint 3 y endpoint 4
    @Override
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);
    }
}
