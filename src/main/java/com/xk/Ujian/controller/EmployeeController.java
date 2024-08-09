package com.xk.Ujian.controller;

import com.xk.Ujian.dto.EmployeeRequest;
import com.xk.Ujian.model.Employee; 
import com.xk.Ujian.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 
import org.springframework.data.domain.Page;  
 

import jakarta.validation.Valid;
 
import java.util.Map; 
import java.util.List;

@RestController 
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
  
  
    //tambah karyawan
     @PostMapping("/add")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        if (employeeService.saveEmployee(employeeRequest.getName(), employeeRequest.getPosition(), employeeRequest.getImageBase64())) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nama user Sudah Terdaftar", HttpStatus.BAD_REQUEST);
        }
    }

   

    

    @GetMapping("/find") 
    public ResponseEntity<Map<String, Object>> findEmployees(
        @RequestParam(defaultValue = "") String searchWord,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {            
     
       // Page<EmployeeDTB> employeePage = employeeService.getEmployee(searchWord, page, size);
        Page<Employee> employeePage = employeeService.searchEmployees(searchWord, page, size);
        
  
    Map<String, Object> response = new HashMap<>();
    
    // Extracting employee data from the page
    List<Map<String, Object>> employees = new ArrayList<>();
    for (Employee employee : employeePage.getContent()) {
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("id", employee.getId());
        employeeData.put("name", employee.getName());
        employeeData.put("position", employee.getPosition());
        employeeData.put("imageBase64", employee.getImageBase64());
        employees.add(employeeData);
    }
    
    response.put("data", employees);
    response.put("totalCount", employeePage.getTotalElements());

    return ResponseEntity.ok(response);

        
    }


    //tambah karyawan
    @PostMapping("/update")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        if (employeeService.updateEmployee(employeeRequest.getId(),employeeRequest.getName(), employeeRequest.getPosition(), employeeRequest.getImageBase64())) {
            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Nama user Sudah Terdaftar", HttpStatus.BAD_REQUEST);
        }
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) { 
        if (employeeService.deleteEmployee(id)) {
            return new ResponseEntity<>("OK", HttpStatus.OK); // 204 No Content
        } else {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
    
   

 


}

