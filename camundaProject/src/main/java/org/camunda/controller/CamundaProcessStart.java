package org.camunda.controller;

import org.camunda.entity.Employee;
import org.camunda.service.CamundaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@RequestMapping("/process")
public class CamundaProcessStart {

    @Autowired
    private CamundaService camundaService;

    @PostMapping("/start")
    public boolean processStart(@RequestBody Map<String, Object> processInput) throws MessagingException, UnsupportedEncodingException {
        System.out.println("in processStart");
        String employeeId = (String) processInput.get("employeeId");
        return camundaService.camundaProcessStart( processInput,employeeId);
    }
}
