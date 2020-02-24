package com.spring.demo.employeedetails.dto;

import com.spring.demo.employeedetails.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {


    private Long id;


    private String firstName;

    private String lastName;

    private AddressDto addressDto;
}
