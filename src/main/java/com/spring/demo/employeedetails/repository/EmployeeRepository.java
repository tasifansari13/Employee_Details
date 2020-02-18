package com.spring.demo.employeedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.employeedetails.entity.EmployeeEntity;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    EmployeeEntity getByLastName(String lastName);
}