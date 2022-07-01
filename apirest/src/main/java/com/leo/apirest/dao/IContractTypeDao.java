package com.leo.apirest.dao;

import com.leo.apirest.models.ContractType;

import java.util.List;

public interface IContractTypeDao {
    public List<ContractType> getContractType();
    ContractType getContractTypeById(Integer id);
}
