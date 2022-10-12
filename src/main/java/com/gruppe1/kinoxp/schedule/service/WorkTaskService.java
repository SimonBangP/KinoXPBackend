package com.gruppe1.kinoxp.schedule.service;

import com.gruppe1.kinoxp.schedule.dto.response.WorkTaskResponse;
import com.gruppe1.kinoxp.schedule.entity.WorkDay;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import com.gruppe1.kinoxp.schedule.repository.WorkTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkTaskService {

    @Autowired
    WorkTaskRepository workTaskRepository;

    public void add(WorkTask workTask) {
        workTaskRepository.save(workTask);
    }

    public void addRange(List<WorkTask> workTasks) {
        workTaskRepository.saveAll(workTasks);
    }

    public WorkTaskResponse getById(int id) {
        Optional<WorkTask> optionalWorkTask = workTaskRepository.findById(id);

        if (optionalWorkTask.isPresent()) {
            return new WorkTaskResponse(optionalWorkTask.get());
        }
        else {
            return null;
        }
    }
}
