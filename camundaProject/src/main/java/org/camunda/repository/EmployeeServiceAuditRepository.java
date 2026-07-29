package org.camunda.repository;

import org.camunda.entity.EmployeeAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServiceAuditRepository extends JpaRepository<EmployeeAudit,Long> {

    List<EmployeeAudit> findByEmployeeId(String employeeId);
}
