package org.camunda.controller;

import org.camunda.service.CamundaService;
import org.camunda.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendmail/{employeeId}")
    public String sendMailRecipent(@PathVariable String employeeId){
        System.out.println("username::"+employeeId);
        mailService.getSenderEmailDetails(employeeId);
        return "";
    }

    @GetMapping("/test")
    public String sendMail(){
        System.out.println("username::");

        return "";
    }
}
