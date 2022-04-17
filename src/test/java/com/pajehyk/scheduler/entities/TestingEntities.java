package com.pajehyk.scheduler.entities;

import static org.junit.jupiter.api.Assertions.*;

import com.pajehyk.scheduler.repositories.TaskInListRepository;
import com.pajehyk.scheduler.repositories.TaskListRepository;
import com.pajehyk.scheduler.repositories.TaskRepository;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@SpringBootTest
public class TestingEntities {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskInListRepository taskInListRepository;
    @Autowired
    private TaskListRepository taskListRepository;
    @Autowired
    private TelegramUserRepository telegramUserRepository;
    @Test
    @Rollback
    @Transactional
    public void TestingTask() {
        Task task = new Task("taskName", 1L, "description",
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        Task savedTask = taskRepository.save(task);
        Task gottenTask = taskRepository.getById(savedTask.getId());
        assertTrue(gottenTask.equals(savedTask));
    }
    @Test
    @Rollback
    @Transactional
    public void TestingTaskInList() {
        TaskInList taskInList = new TaskInList(1L, 1L);
        TaskInList savedTaskInList = taskInListRepository.save(taskInList);
    }
    @Test
    @Rollback
    @Transactional
    public void TestingTaskList() {
        TaskList taskList = new TaskList("name", "description", 1L, 1L);
        TaskList savedTaskList = taskListRepository.save(taskList);
    }
}
