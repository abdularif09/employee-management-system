package org.camunda.DTO;

import lombok.Data;
import org.camunda.entity.Employee;

import java.util.Date;

@Data
public class DTOTask {

    private String taskId;
    private String taskName;
    private String assignee;
    private Date createTime;
    private String due;
    private String followUp;
    private String lastUpdated;
    private String delegationState;
    private String description;
    private String executionId;
    private String owner;
    private String parentTaskId;
    private String priority;
    private String processDefinitionId;
    private String processInstanceId;
    private String taskDefinitionKey;

    private String caseExecutionId;
    private String caseInstanceId;
    private String caseDefinitionId;
    private String suspended;
    private String formKey;
    private String tenantId;

    private String employeeId;
    private String employeeName;
    private String mobileNumber;
    private String designation;


}
