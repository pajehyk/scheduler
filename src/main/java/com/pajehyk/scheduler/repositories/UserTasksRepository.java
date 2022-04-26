package com.pajehyk.scheduler.repositories;

import com.pajehyk.scheduler.entities.UserTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserTasksRepository extends JpaRepository<UserTasks, Long> {
/*
    @Query("select UserTasks.taskNum, Task.taskName from UserTasks t " +
            "inner join Task b on Task.id = UserTasks.taskId where UserTasks.userId = :userId")
*/
    @Query("select u, t from UserTasks u inner join Task t on u.taskId = t.id where u.userId = :userId")
    List<UserTasks> getUserTasksById(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("delete from UserTasks where userId = :telegramId and taskNum = :taskNum")
    public void completeTaskByTelegramIdTaskNum(Long telegramId, Long taskNum);

    @Transactional
    @Modifying
    @Query("update UserTasks set taskNum = taskNum - 1 where userId = :telegramId and taskNum > :taskNum")
    public void updateTaskNumsByTelegramIdTaskNum(Long telegramId, Long taskNum);
}
