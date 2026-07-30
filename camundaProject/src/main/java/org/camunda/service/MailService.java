package org.camunda.service;

import org.camunda.DTO.DTOUserEntity;
import org.camunda.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;



@Service
public class MailService {



    @Autowired
    private HttpServletRequest request;

    @Autowired
    TaskListService taskListService;

    public Employee getSenderEmailDetails(String username){
        ResponseEntity<Employee> responseEntity = taskListService.getTokenFromHeader(request,
                "http://localhost:8095/emp/getemployeeById/"+username,HttpMethod.GET, Employee.class);
        Employee employeeEntity = (Employee)responseEntity.getBody();
        ///assert userEntity != null;
        return employeeEntity;
    }

}
