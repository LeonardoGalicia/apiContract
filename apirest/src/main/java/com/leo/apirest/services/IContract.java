package com.leo.apirest.services;

import com.leo.apirest.models.Contract;
import com.leo.apirest.models.Employee;

import java.util.List;

public interface IContract {
    List<Contract> findAll();
    void addContract(Contract contract);
    Contract updateContractByIdEmployee(Integer idEmployee);
}
