package com.leo.apirest.dao;

import com.leo.apirest.models.ContractType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContractTypeDaoImp implements IContractTypeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ContractType> getContractType() {
        String query = "FROM ContractType";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ContractType getContractTypeById(Integer id) {
        String query = "FROM ContractType WHERE idContractType ="+id;
        return (ContractType) entityManager.createQuery(query).getSingleResult();
    }
}
