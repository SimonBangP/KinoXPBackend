package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.TaskName;
import com.gruppe1.kinoxp.schedule.entity.WorkTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {




}
