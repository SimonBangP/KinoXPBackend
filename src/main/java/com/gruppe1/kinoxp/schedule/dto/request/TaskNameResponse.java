package com.gruppe1.kinoxp.schedule.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.gruppe1.kinoxp.schedule.entity.TaskName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CrossOrigin
public class TaskNameResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    public TaskNameResponse(int id, String taskName) {
        this.id = id;
        this.taskName = taskName;
    }
    public TaskNameResponse (TaskName taskName){
        this.id = taskName.getId();
        this.taskName = taskName.getTaskName();
    }

}
