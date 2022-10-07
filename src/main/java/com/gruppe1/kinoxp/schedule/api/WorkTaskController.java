package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.request.TaskNameRequest;
import com.gruppe1.kinoxp.schedule.dto.response.TaskNameResponse;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import com.gruppe1.kinoxp.schedule.service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/worktasks")
public class WorkTaskController {

    @Autowired
    TaskNameService taskNameService;
    @Autowired
    WorkDayService workDayService;
    @Autowired
    WorkTaskService workTaskService;


    @GetMapping("/taskname")
    public List<TaskNameResponse> getTaskNames (){
        return taskNameService.getTaskName();
    }

    @PostMapping("/taskname")
    public TaskNameResponse addTaskName(@RequestBody TaskNameRequest body){
        return taskNameService.addTaskName(body);
    }


    @DeleteMapping("/taskname/{id}")
    public void deleteTaskNamebyId(@PathVariable int id){
        taskNameService.deleteTaskNameById(id);
    }

    /*@DeleteMapping("/taskname/{taskname}")
    public void deleteTaskNameByTaskName (@PathVariable String taskName){
        taskNameService.deleteTaskNameByTaskName(taskName);

    }*/
}
