package com.fsd.service.project.manager.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private String employeeId;
}
