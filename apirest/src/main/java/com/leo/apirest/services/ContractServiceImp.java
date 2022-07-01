package com.leo.apirest.services;

import com.leo.apirest.dao.IContractDao;
import com.leo.apirest.dao.IContractTypeDao;
import com.leo.apirest.dao.IEmployeeDao;
import com.leo.apirest.models.Contract;
import com.leo.apirest.models.ContractType;
import com.leo.apirest.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImp implements IContract{

    public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    private IContractDao iContractDao;

    @Autowired
    private IContractTypeDao contractTypeDao;
    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    public List<Contract> findAll() {
        return iContractDao.getContracts();
    }


    //endpoint 2
    @Override
    public void addContract(Contract contract) {


        List<Contract> contractsByIdEmployee = iContractDao.getContractByIdEmployee(contract.getEmployee().getIdEmployee());
        if(contractsByIdEmployee != null){
            for (Contract contract2: contractsByIdEmployee){
                contract2.setIsActive(false);
                contract2.setDateTo(DTF.format(LocalDateTime.now()));
                iContractDao.updateContract(contract2);
            }
        }

        contract.setDateCreated(DTF.format(LocalDateTime.now()));
        iContractDao.addContract(contract);
    }

    //endpoint 5
    @Override
    public Contract updateContractByIdEmployee(Integer idEmployee) {
        List<Contract> listContract = new ArrayList<>();
        Contract contractResponse = null;
        listContract = iContractDao.getContractByIdEmployee(idEmployee);
        if(listContract != null){
            for (Contract contract1 : listContract){
                contract1.setIsActive(false);
                contract1.setDateTo(DTF.format(LocalDateTime.now()));
                iContractDao.updateContract(contract1);
                contractResponse = contract1;
            }
        }else {
            return null;
        }

        return contractResponse;
    }


}
