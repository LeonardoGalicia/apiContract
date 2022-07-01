package com.leo.apirest.dao;

import com.leo.apirest.models.Contract;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CrontractDaoImp implements IContractDao{

    @PersistenceContext
    private EntityManager entityManager;


    //se usa en el endpoint 1
    @Override
    public List<Contract> getContracts() {
        String query = "FROM Contract";
        return entityManager.createQuery(query).getResultList();
    }


    //se usa en el endpoint 2 y edpoint 5
    @Override
    public List<Contract> getContractByIdEmployee(Integer id) {
        String query = "FROM Contract WHERE idEmployee="+id +" AND isActive = true";
        return entityManager.createQuery(query).getResultList();
    }

    //se usa en el endpoint 2
    @Override
    public void addContract(Contract contract) {

        entityManager.merge(contract);
    }

    // se usa en el point 5
    @Override
    public void updateContract(Contract contract) {
        entityManager.merge(contract);
    }
}
