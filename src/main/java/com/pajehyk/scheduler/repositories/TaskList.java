package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskList extends JpaRepository<Task, Long> {
    
}
