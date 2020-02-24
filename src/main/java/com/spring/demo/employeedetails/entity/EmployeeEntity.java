package com.spring.demo.employeedetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TBL_EMPLOYEES")
public class EmployeeEntity {

    @Id
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    @MapsId
    private AddressEntity addressEntity;

}
