package com.leo.apirest.dao;

import com.leo.apirest.models.Contract;

import java.util.List;

public interface IContractDao {

    List<Contract> getContracts();
    List<Contract> getContractByIdEmployee(Integer id);
    void addContract(Contract contract);
    void updateContract(Contract contract);
}
