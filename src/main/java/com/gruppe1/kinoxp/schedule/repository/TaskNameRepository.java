package com.gruppe1.kinoxp.schedule.repository;

import com.gruppe1.kinoxp.schedule.entity.TaskName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskNameRepository extends JpaRepository<TaskName, Integer> {

    Optional<TaskName> findByTaskName(String taskName);

    long deleteByTaskName (String taskName);

}
