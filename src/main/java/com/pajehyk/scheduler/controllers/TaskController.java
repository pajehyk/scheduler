package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    public Task addTask(Task task) {
        Task task1 = taskRepository.save(task);
        return task1;
    }

    public Task fetchTask(Long taskId) {
        Task fetchedTask = taskRepository.getById(taskId);
        return fetchedTask;
    }
    public void changeTaskName(Long taskId, String taskName) {
        Task fetchedTask = fetchTask(taskId);
        fetchedTask.setTaskName(taskName);
        taskRepository.save(fetchedTask);
    }

    public void changeTaskDescription(Long taskId, String taskDescription) {
        Task fetchedTask = fetchTask(taskId);
        fetchedTask.setDescription(taskDescription);
        taskRepository.save(fetchedTask);
    }

}
