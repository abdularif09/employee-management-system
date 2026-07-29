package org.camunda.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaService {

    @Autowired
    private RuntimeService runtimeService;

    public boolean camundaProcessStart(  Map<String, Object> processInput,String employeeId){
               System.out.println("test "+processInput.get("employeeId"));
        runtimeService.startProcessInstanceByKey("exclusiveorgatewayId", employeeId, processInput);
        return true;
    }
}
