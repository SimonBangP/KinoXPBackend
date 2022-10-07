package com.gruppe1.kinoxp.schedule.dto.request;

import com.gruppe1.kinoxp.schedule.entity.TaskName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskNameRequest {

    String taskName;

    public static TaskName getTaskNameEntity(TaskNameRequest taskNameRequest){
        return TaskName.builder()
                .taskName(taskNameRequest.getTaskName())
                .build();
    }

    public TaskNameRequest(TaskName taskName){
        this.taskName = taskName.getTaskName();
    }
}
