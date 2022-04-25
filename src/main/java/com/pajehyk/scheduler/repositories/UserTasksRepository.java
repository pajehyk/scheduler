package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserTasksRepository extends JpaRepository<UserTasks, Long> {
/*
    @Query("select UserTasks.taskNum, Task.taskName from UserTasks t " +
            "inner join Task b on Task.id = UserTasks.taskId where UserTasks.userId = :userId")
*/
    @Query("select u, t from UserTasks u inner join Task t on u.taskId = t.id where u.userId = :userId")
    List<UserTasks> getUserTasksById(@Param("userId") Long userId);
}
