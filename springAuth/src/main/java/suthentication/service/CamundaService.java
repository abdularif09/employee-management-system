package suthentication.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suthentication.entity.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaService {

    private final String apiUrl = "http://localhost:8095/process/start";

    @Autowired
    private HttpServletRequest request;

    public void startCamundaProcess(Employee employee){

        String token = request.getHeader("Authorization");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        Map<String, Object> processInput = new HashMap<>();

        processInput.put("employeeId", employee.getEmployeeId());
        processInput.put("employeeName", employee.getEmployeeName());

        HttpEntity<Map> entity = new HttpEntity<>(processInput, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> response =
                restTemplate.exchange("http://localhost:8095/process/start",HttpMethod.POST,entity, Boolean.class);
    }
}
