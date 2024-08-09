package com.xk.Ujian.service;

 
import com.xk.Ujian.model.Employee; 
import com.xk.Ujian.repository.EmployeeRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest; 
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository; 
     
    


    // proses simpan data karyawan
    
    public boolean saveEmployee(String name, String position, String imageBase64) {
      
    if (employeeRepository.findByName(name) != null) {
        return false;  
    }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setImageBase64(imageBase64);
        employeeRepository.save(employee);
        return true;  
 
    }

     
    public Page<Employee> searchEmployees(String searchTerm, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.search(searchTerm, pageable);
    }
    
  

    public boolean updateEmployee(Long id,String name, String position, String imageBase64) {
      
        if (!employeeRepository.existsById(id)) {
            return false;   
        }
        
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(name);
            employee.setPosition(position);
            employee.setImageBase64(imageBase64);
            employeeRepository.save(employee);  // Save updated employee
            return true;
        }else{
            return false;  
        }
             
    }


    public boolean deleteEmployee(Long id) {
        
        if (!employeeRepository.existsById(id)) {
            return false;   
        }
     
        employeeRepository.deleteById(id);
        return true;  
    }
}
