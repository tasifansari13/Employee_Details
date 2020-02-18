package com.spring.demo.employeedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.employeedetails.entity.EmployeeEntity;
import com.spring.demo.employeedetails.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
		List<EmployeeEntity> list = employeeService.getAllEmployees();

		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		EmployeeEntity entity = employeeService.getEmployeeById(id);

		return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
			throws Exception {
		EmployeeEntity updated = employeeService.createOrUpdateEmployee(employee);
		return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		employeeService.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping("/byName/{firstName}")
	public ResponseEntity<List<EmployeeEntity>> findDetailsByLastName(@PathVariable("firstName") String firstName)
			throws Exception {
		System.out.println("-----" + firstName);
		List<EmployeeEntity> list = employeeService.findDetailsByLastName(firstName);

		return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);

	}

}
