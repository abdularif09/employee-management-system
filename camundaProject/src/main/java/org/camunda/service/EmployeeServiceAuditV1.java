package org.camunda.service;

import org.camunda.entity.EmployeeAudit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServiceAuditV1 {
    List<EmployeeAudit> getEmployeeById(String employeeId);
}
