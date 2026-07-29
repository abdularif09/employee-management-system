package org.camunda.javaservice;
//import jakarta.annotation.PostConstruct;
import org.camunda.bpm.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class FormDeployment {

    @Autowired
    private RepositoryService repositoryService;

    @PostConstruct
    public void deployForm() {
        System.out.println("after post consttruct");
       repositoryService.createDeployment()
               .name("Camunda Forms").addClasspathResource("process/employee.form")
               .addClasspathResource("process/diagram_1.bpmn")
                .deploy();
    }
}