package org.camunda.javaservice;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component()
public class javaServiceDelegationTask implements JavaDelegate
{

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("test");
        execution.setVariable("status", "APPROVEDS");
        execution.getCurrentActivityId();

        execution.getCurrentActivityName();

        execution.getVariables();

        execution.getVariable("status");
        Map<String,Object> vars = execution.getVariables();   // Breakpoint here
        System.out.println(vars);
    }
}
