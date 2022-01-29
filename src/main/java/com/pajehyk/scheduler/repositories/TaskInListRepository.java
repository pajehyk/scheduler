package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.TaskInList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskInListRepository extends JpaRepository<TaskInList, Long> {
    
}
