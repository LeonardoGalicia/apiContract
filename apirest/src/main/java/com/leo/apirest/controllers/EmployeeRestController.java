package com.leo.apirest.controllers;

import com.leo.apirest.models.ActiveEmployeeResponse;
import com.leo.apirest.models.Employee;
import com.leo.apirest.services.IEmployee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
public class EmployeeRestController {

    @Autowired
    private IEmployee employeeService;



    @Operation(summary = "3. add new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee add",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "There is already an employee registered with the rfc",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid rfc",
                    content = @Content) })
    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Map<String, Object> response = new HashMap<>();
        Employee responseEmployee = employeeService.addEmployee(employee);
        if(responseEmployee == null){
            response.put("message","There is already an employee registered with the rfc: "+employee.getTextIdNumber());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if(responseEmployee.getTextIdNumber().equals("invalid")){
            response.put("message","Invalid rfc ");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        else {
            response.put("message","successfully added");
            response.put("employee",employee);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @Operation(summary = "4. Update employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee update",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "There is already an employee registered with the rfc",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid rfc",
                    content = @Content) })
    @PutMapping("/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        Map<String, Object> response = new HashMap<>();
        Employee responseEmployee = employeeService.updateEmployee(employee);
        if(responseEmployee == null){
            response.put("message","There is already an employee registered with the rfc: "+employee.getTextIdNumber());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if(responseEmployee.getTextIdNumber().equals("invalid")){
            response.put("message","Invalid rfc ");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            response.put("message","successfully updated");
            response.put("employee",employee);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


    @Operation(summary = "1. list of active employees")
    @GetMapping("/activeEmployees")
    public List<ActiveEmployeeResponse> activeEmployees(){
        return employeeService.findActiveEmployees();
    }
}
