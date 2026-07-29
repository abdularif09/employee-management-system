package org.camunda.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_audit")
@Data
public class EmployeeAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @Column(name="employee_id" , nullable = false)
    private String employeeId;

    @Column(name="task_id", nullable = false)
    private String taskId;

    @Column(name="process_instance_id", nullable = false)
    private String processInstanceId;

    @Column(name="action", nullable = false)
    private String action;

    @Column(name="task_name", nullable = false)
    private String task_name;

    @Column(name="performed_by", nullable = false)
    private String performed_by;

    @Column(name="remarks", nullable = false)
    private String remarks;

    @Column(name="old_status", nullable = false)
    private String old_status;

    @Column(name="new_status", nullable = false)
    private String new_status;

    @CreationTimestamp
    private LocalDateTime actionTime;

}
