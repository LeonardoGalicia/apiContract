package com.leo.apirest.services;

import com.leo.apirest.dao.IContractTypeDao;
import com.leo.apirest.models.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeServiceImp implements IContractType{

    @Autowired
    IContractTypeDao contractTypeDao;

    @Override
    public List<ContractType> findAll() {
        return contractTypeDao.getContractType();
    }
}
