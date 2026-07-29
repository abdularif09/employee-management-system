package org.camunda.service.impl;

import org.camunda.entity.EmployeeAudit;
import org.camunda.repository.EmployeeServiceAuditRepository;
import org.camunda.service.EmployeeServiceAuditV1;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServiceAuditV1 {

    private final EmployeeServiceAuditRepository employeeServiceAuditRepository;

    public EmployeeServiceImpl(EmployeeServiceAuditRepository employeeServiceAuditRepository) {
        this.employeeServiceAuditRepository = employeeServiceAuditRepository;
    }

    @Override
    public List<EmployeeAudit> getEmployeeById(String employeeId) {
        return employeeServiceAuditRepository.findByEmployeeId(employeeId);
    }
}
