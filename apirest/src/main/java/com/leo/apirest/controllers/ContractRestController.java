package com.leo.apirest.controllers;

import com.leo.apirest.dao.IContractDao;
import com.leo.apirest.models.Contract;
import com.leo.apirest.services.IContract;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ContractRestController {

    @Autowired
    private IContract iContractService;


    //endpoint 2
    @Operation(summary = "2. add new contract " +
            "- if the employee does not have a contract add it with the data sent " +
            "- if the employee has an active contract, it cancels it and updates its dateTo to the current date, and registers the new contract.")
    @PostMapping("/contract")
    public void createContract(@RequestBody Contract contract){
        iContractService.addContract(contract);
    }

    @Operation(summary = "5. delete employee contract selected by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contract remove",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "error, the employee has no contracts",
                    content = @Content), })
    @GetMapping("/contract/{idEmployee}")
    public ResponseEntity<?> updateContractByIdEmployee(@PathVariable Integer idEmployee){
        Map<String, Object> response = new HashMap<>();
        Contract contract1 = iContractService.updateContractByIdEmployee(idEmployee);
        if(contract1 == null){
            response.put("message","error, the employee has no contracts");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            response.put("message","Contract Terminated Correctly");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }

    }
}
