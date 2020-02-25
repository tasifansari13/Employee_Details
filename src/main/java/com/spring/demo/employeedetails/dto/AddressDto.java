package com.spring.demo.employeedetails.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private long id;

    private long pinCode;

    private String city;

    private EmployeeDto employeeDto;
}
