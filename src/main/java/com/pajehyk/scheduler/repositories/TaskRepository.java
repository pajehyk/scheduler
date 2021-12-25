package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
