package suthentication.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suthentication.entity.Employee;
import suthentication.service.CamundaService;
import suthentication.service.EmployeeService;

import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeOnboarding {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CamundaService camundaService;

    @PostConstruct
    public void init() {
        System.out.println("EmployeeOnboarding Controller Loaded");
    }

    @PostMapping("/employeeonboarding")
    public ResponseEntity<Employee> employeeOnboard(@RequestBody Employee empRequest) {
        System.out.println("before save in employee Onboarding");
        Employee employee = employeeService.saveEmployee(empRequest);
        System.out.println("after save in employee Onboarding");
        //String businessKey = (String) requestBody.get("businessKey");
        camundaService.startCamundaProcess(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getemployeeById/{employeeId}")
    public Optional<Employee> getEmployeedetailsById(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
}
