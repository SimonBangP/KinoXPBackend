package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.repository.TaskNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskNameService {

    @Autowired
    TaskNameRepository taskNameRepository;

    public void add(TaskName taskName) {
        taskNameRepository.save(taskName);
    }

    public TaskName getByName(String taskName) {
        Optional<TaskName> optionalTaskName = taskNameRepository.findByTaskName(taskName);

        if (optionalTaskName.isPresent()) {
            return optionalTaskName.get();
        }
        else {
            return null;
        }
    }

}
