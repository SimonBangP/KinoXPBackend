package com.gruppe1.kinoxp.schedule.api;


import com.gruppe1.kinoxp.schedule.dto.request.TaskNameResponse;
import com.gruppe1.kinoxp.schedule.service.TaskNameService;
import com.gruppe1.kinoxp.schedule.service.WorkDayService;
import com.gruppe1.kinoxp.schedule.service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
