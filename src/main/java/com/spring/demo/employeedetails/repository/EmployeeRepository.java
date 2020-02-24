package com.spring.demo.employeedetails.repository;

import com.spring.demo.employeedetails.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


    EmployeeEntity findByFirstName(String firstName);
}