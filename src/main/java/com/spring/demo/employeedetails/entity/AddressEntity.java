package com.spring.demo.employeedetails.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AddressEntity {


    @Id
    @GeneratedValue
    private long id;

    private long pinCode;

    private String city;

    @OneToOne(mappedBy = "addressEntity",  cascade = CascadeType.ALL)
    private EmployeeEntity employeeEntity;
}
