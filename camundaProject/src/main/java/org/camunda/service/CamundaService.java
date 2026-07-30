package org.camunda.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.entity.Employee;
import org.camunda.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    MailServiceImpl mailService;

    public boolean camundaProcessStart(  Map<String, Object> processInput,String employeeId) throws MessagingException, UnsupportedEncodingException {
               System.out.println("test "+processInput.get("employeeId"));
        runtimeService.startProcessInstanceByKey("exclusiveorgatewayId", employeeId, processInput);
        mailService.sendMail("nasir","");
        System.out.println("test REstults");
        return true;
    }
}
