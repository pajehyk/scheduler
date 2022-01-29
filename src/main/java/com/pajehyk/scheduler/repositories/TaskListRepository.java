package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.TaskList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    
}
