package org.camunda.controller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.entity.EmployeeAudit;
import org.camunda.service.EmployeeServiceAudit;
import org.camunda.service.EmployeeServiceAuditV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/history")
public class EmployeeAuditController {

    @Autowired
    private EmployeeServiceAudit employeeServiceAudit;

    @Autowired
    private EmployeeServiceAuditV1 employeeServiceAuditV1;

    @GetMapping("/getHistoryDetails")
    public List<EmployeeAudit> getEmployeeHistory(){
        return employeeServiceAudit.getEmployeeHistory();
    }

    @GetMapping("/getHistoryDetailsByEmployeeId/{employeeId}")
    public List<EmployeeAudit> getHistoryDetailsByEmployeeId(@PathVariable String employeeId){
        return employeeServiceAuditV1.getEmployeeById(employeeId);
    }

    @GetMapping("/addEmployee")
    public EmployeeAudit addEmployeeHistory(@RequestBody  EmployeeAudit employeeAudit){
        return employeeServiceAudit.addEmployeeHistory(employeeAudit);
    }

    @GetMapping("/updateEmployee")
    public EmployeeAudit updateEmployeeAudit(Long Id,EmployeeAudit employeeAudit){
        return employeeServiceAudit.updateEmployeeAudit(Id,employeeAudit);
    }

}
