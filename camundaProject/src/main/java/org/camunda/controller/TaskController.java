package org.camunda.controller;

import org.camunda.DTO.DTOTask;
import org.camunda.DTO.DTOTaskComplete;
import org.camunda.bpm.engine.task.Task;
import org.camunda.entity.Employee;
import org.camunda.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskListService taskListService;

    @GetMapping("/getTasks")
    public List<DTOTask> getTaskList(){
        return taskListService.getTasks();
    }

    @PostMapping("/completeTask/{taskId}")
    public void completeTask(@RequestBody DTOTaskComplete dtoTaskComplete){
         taskListService.completeTask(dtoTaskComplete);
    }

    @GetMapping("/getTaskByTaskId/{taskId}")
    public Employee getTaskByTaskId(@PathVariable String taskId){
        return taskListService.getTaskByTaskId(taskId);
    }

    @PostMapping("/claim/{taskId}/{userId}")
    public ResponseEntity<String> claimTaskByUserId(@PathVariable String taskId, @PathVariable String userId){
        taskListService.claimTaskByUser(taskId,userId);
        return ResponseEntity.ok("Task claimed successfully");
    }
}
