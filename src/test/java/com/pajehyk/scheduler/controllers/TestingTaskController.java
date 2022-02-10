package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@SpringBootTest
public class TestingTaskController {
    @Autowired
    private TaskController taskController;
    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Transactional
    public void testAddTask() {
        Task task = taskController.addTask(new Task("", -1L,
                "", new Date(1), new Date(1)));
        Task fetchedTask = taskRepository.getById(task.getId());
        assertTrue(task.equals(fetchedTask));
    }

    @Test
    @Transactional
    public void testFetchTask() {
        Task task = taskRepository.save(new Task("", -1L,
                "", new Date(1), new Date(1)));
        Task fetchedTask = taskController.fetchTask(task.getId());
        assertTrue(fetchedTask.equals(task));
    }

    @Test
    @Transactional
    public void testChangeTaskName() {
        String taskName = "taskName";
        Task task = taskController.addTask(new Task("", -1L,
                "", new Date(1), new Date(1)));
        taskController.changeTaskName(task.getId(), taskName);
        Task fetchedTask = taskController.fetchTask(task.getId());
        assertTrue(taskName.equals(fetchedTask.getTaskName()));
    }
}
