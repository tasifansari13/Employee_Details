package com.spring.demo.employeedetails.controller;

import com.spring.demo.employeedetails.dto.EmployeeDto;
import com.spring.demo.employeedetails.entity.EmployeeEntity;
import com.spring.demo.employeedetails.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();

        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws Exception {

        log.info("Inside method");
        EmployeeEntity entity = service.getEmployeeById(id);

        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/address/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByAddressId(@PathVariable("id") Long id) throws Exception {

        log.info("Inside method");
        EmployeeDto entity = service.getEmployeeByAddressId(id);

        return new ResponseEntity<EmployeeDto>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity employee)
            throws Exception {
        service.createOrUpdateEmployee(employee);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping("/byName/{firstName}")
    public ResponseEntity findDetailsByLastName(@PathVariable("firstName") String firstName)
            throws Exception {
        System.out.println("-----" + firstName);


        return ResponseEntity.ok(service.findDetailsByFirstName(firstName));

    }

}
