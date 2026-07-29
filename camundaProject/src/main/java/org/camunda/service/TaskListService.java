package org.camunda.service;

import org.camunda.DTO.DTOTask;
import org.camunda.DTO.DTOTaskComplete;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.camunda.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskListService {

    @Autowired
    private  TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HttpServletRequest request;

    public List<DTOTask> getTasks() {
        List<Task> taskList = taskService.createTaskQuery().active().list();
        List<DTOTask> myTasks = new ArrayList<DTOTask>();
        for(Task task:taskList){
            ProcessInstance processInstance =
                    runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            String employeeId = processInstance.getBusinessKey();
            System.out.println(employeeId);
            DTOTask dtoTask = new DTOTask();
            dtoTask.setTaskId(task.getId());
            dtoTask.setTaskName(task.getName());
            dtoTask.setAssignee(task.getAssignee());
            dtoTask.setProcessInstanceId(task.getProcessInstanceId());
            dtoTask.setCreateTime(task.getCreateTime());
            ResponseEntity<Employee> response = getTokenFromHeader(request,
                    "http://localhost:8095/emp/getemployeeById/"+employeeId,HttpMethod.GET);
            Employee employee = response.getBody();
            if(employee!=null){
                dtoTask.setEmployeeId(employee.getEmployeeId());
                dtoTask.setEmployeeName(employee.getEmployeeName());
                dtoTask.setMobileNumber(employee.getMobileNumber());
                dtoTask.setDesignation(employee.getDesignation());
            }
            myTasks.add(dtoTask);
        }
        return myTasks;
    }

    public ResponseEntity<Employee> getTokenFromHeader(HttpServletRequest request,String Url,HttpMethod restMethod){
        String token = request.getHeader("Authorization");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("authorizationDetails", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response =restTemplate.exchange(Url, restMethod,entity, Employee.class);
        return response;
    }

    public void completeTask(DTOTaskComplete dtoTaskComplete){
        Map<String,Object> vars = new HashMap<>();

        vars.put("decision",dtoTaskComplete.getDecision());
        vars.put("remarks",dtoTaskComplete.getRemarks());
        vars.put("status",dtoTaskComplete.getStatus());
        taskService.complete(dtoTaskComplete.getTaskId(),vars);
    }

    public void claimTaskByUser(String taskId,String userid){
        taskService.claim(taskId,userid);
    }

    public Employee getTaskByTaskId(String taskId){
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();;
        ProcessInstance processInstance =
                runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
        String employeeId = processInstance.getBusinessKey();

        System.out.println(employeeId);
        DTOTask dtoTask = null;
        ResponseEntity<Employee> response = getTokenFromHeader(request,
                "http://localhost:8095/emp/getemployeeById/"+employeeId,HttpMethod.GET);
        Employee employee = response.getBody();

        return employee;
    }
}
