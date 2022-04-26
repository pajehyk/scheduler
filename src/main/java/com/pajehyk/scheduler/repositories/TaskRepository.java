package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Transactional
    @Modifying
    @Query("update Task set completed = true where id = :id")
    public void completeById(Long id);
}

