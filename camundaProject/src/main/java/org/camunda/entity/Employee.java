package org.camunda.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_onboarding")
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", unique = true, nullable = false)
    private String employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    private String gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String designation;

    private String department;

    private String manager;

    @Column(name = "employment_type")
    private String employmentType;

    private String location;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    private BigDecimal salary;

    @Column(name = "aadhar_number")
    private String aadharNumber;

    @Column(name = "resume_path")
    private String resumePath;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "hr_remarks", columnDefinition = "TEXT")
    private String hrRemarks;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}

