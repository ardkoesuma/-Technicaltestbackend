package com.xk.Ujian.repository;

import com.xk.Ujian.model.Employee; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 

public interface EmployeeRepository extends JpaRepository<Employee, Long> { 
 
  
    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :searchWord, '%')) OR LOWER(e.position) LIKE LOWER(CONCAT('%', :searchWord, '%'))")
    Page<Employee> search(@Param("searchWord") String searchWord, Pageable pageable);

    Employee findByName(String name);

    

}