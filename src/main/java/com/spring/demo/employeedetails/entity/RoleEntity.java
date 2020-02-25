package com.spring.demo.employeedetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ROLE_ENTITY")
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String roleName;
        private String displayName;
}
