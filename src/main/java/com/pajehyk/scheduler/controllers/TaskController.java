package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @PostMapping("/add")
    public Task addTask(Task task) {
        Task task1 = taskRepository.save(task);
        return task1;
    }
    @GetMapping("/fetch")
    public Task fetchTask(Long taskId) {
        Task fetchedTask = taskRepository.getById(taskId);
        return fetchedTask;
    }
    @PutMapping("/changeName")
    public void changeTaskName(@RequestBody Map<String, String> json) {
        Long taskId = Long.parseLong(json.get("taskId"));
        String taskName = json.get("taskName");
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
