package org.camunda.service;

import org.camunda.entity.EmployeeAudit;
import org.camunda.repository.EmployeeServiceAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceAudit {

    @Autowired
    private EmployeeServiceAuditRepository employeeServiceAuditRepository;

    public List<EmployeeAudit> getEmployeeHistory(){
        return employeeServiceAuditRepository.findAll();
    }

    public EmployeeAudit addEmployeeHistory(EmployeeAudit employeeAudit){
        return employeeServiceAuditRepository.save(employeeAudit);
    }

    public Optional<EmployeeAudit> getHistoryDetailsByEmployeeId(String employeeId){
        return employeeServiceAuditRepository.findById(Long.parseLong(employeeId));
    }

    public EmployeeAudit updateEmployeeAudit(Long  id, EmployeeAudit employeeAudit){
       EmployeeAudit dbEmployeeAudit = employeeServiceAuditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
         dbEmployeeAudit.setEmployeeId(employeeAudit.getEmployeeId());
         dbEmployeeAudit.setAction(employeeAudit.getAction());
         dbEmployeeAudit.setNew_status(employeeAudit.getNew_status());
         dbEmployeeAudit.setTask_name(employeeAudit.getTask_name());
         dbEmployeeAudit.setPerformed_by(employeeAudit.getPerformed_by());
         dbEmployeeAudit.setRemarks(employeeAudit.getRemarks());
        return employeeServiceAuditRepository.save(dbEmployeeAudit);

    }

}
