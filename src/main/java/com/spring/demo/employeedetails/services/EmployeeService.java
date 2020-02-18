package com.spring.demo.employeedetails.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.employeedetails.entity.EmployeeEntity;
import com.spring.demo.employeedetails.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = employeeRepository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeEntity getEmployeeById(Long id) throws Exception {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws Exception {
		Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getId());

		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = employeeRepository.save(newEntity);

			return newEntity;
		} else {
			entity = employeeRepository.save(entity);

			return entity;
		}
	}

	public void deleteEmployeeById(Long id) throws Exception {
		Optional<EmployeeEntity> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}


	public List<EmployeeEntity> findDetailsByLastName(String firstName) throws Exception {
		System.out.println("Inside service" + firstName);
		EmployeeEntity employee = employeeRepository.getByLastName(firstName);
		System.out.println("Employee object" + employee);
		return null;
//		if (employee.size() > 0) {
//			return employee;
//		} else {
//			return new ArrayList<EmployeeEntity>();
//		}
	}
}
