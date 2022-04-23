package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTasksRepository extends JpaRepository<UserTasks, Long> {
}
