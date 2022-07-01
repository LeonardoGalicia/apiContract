package com.leo.apirest.controllers;


import com.leo.apirest.models.ContractType;
import com.leo.apirest.services.IContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContractTypeRestController {

    @Autowired
    private IContractType contractTypeService;

   /* @GetMapping("/contractTypes")
    public List<ContractType> contractTypes(){
        return contractTypeService.findAll();
    }
    @GetMapping("/prueba")
    public String prueba(){
        return "prueba";
    }*/
}
