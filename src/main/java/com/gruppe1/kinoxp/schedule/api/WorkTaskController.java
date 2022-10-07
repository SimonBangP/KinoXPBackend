package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.request.TaskNameRequest;
import com.gruppe1.kinoxp.schedule.dto.response.TaskNameResponse;
import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import com.gruppe1.kinoxp.schedule.service.WorkTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("api/v1/worktasks")
public class WorkTaskController {

    @Autowired
    TaskNameService taskNameService;
    @Autowired
    WorkDayService workDayService;
    @Autowired
    WorkTaskService workTaskService;


    @Operation(summary = "Gets all available task names", responses = {@ApiResponse(responseCode = "200")})
    @GetMapping("/taskname")
    public ResponseEntity<List<TaskNameResponse>> getTaskNames (){
        return new ResponseEntity<>(taskNameService.getTaskName(), HttpStatus.OK);
    }

    @Operation(summary = "Adds a new task", responses = {@ApiResponse(responseCode = "201")})
    @PostMapping("/taskname")
    public ResponseEntity<TaskNameResponse> addTaskName(@RequestBody TaskNameRequest body){
        return new ResponseEntity<>(taskNameService.addTaskName(body), HttpStatus.CREATED);
    }


    @Operation(summary = "Deletes a task by name", responses = {@ApiResponse(responseCode = "200")})
    @DeleteMapping("/taskname/{name}")
    public ResponseEntity<Void> deleteTaskNamebyId(@PathVariable String name){
        taskNameService.deleteTaskNameByTaskName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
