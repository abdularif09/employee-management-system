package org.camunda.Listners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.entity.EmployeeAudit;
import org.camunda.service.EmployeeServiceAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTaskListners  implements TaskListener {

    @Autowired
    EmployeeServiceAudit employeeServiceAudit;

    @Override
    public void notify(DelegateTask delegateTask) {
        EmployeeAudit eaudit = new EmployeeAudit();
        String employeeId = delegateTask.getExecution().getBusinessKey();
        eaudit.setEmployeeId(delegateTask.getExecution().getBusinessKey());
        eaudit.setTask_name(delegateTask.getName());
        eaudit.setTaskId(delegateTask.getId());
        eaudit.setPerformed_by(delegateTask.getAssignee());
        eaudit.setProcessInstanceId(delegateTask.getProcessInstanceId());
        eaudit.setRemarks((String) delegateTask.getVariable("remarks"));
        eaudit.setNew_status((String) delegateTask.getVariable("status"));
        eaudit.setAction(delegateTask.getEventName());
        employeeServiceAudit.addEmployeeHistory(eaudit);
        System.out.println("Audit saved successfully");
    }
}
