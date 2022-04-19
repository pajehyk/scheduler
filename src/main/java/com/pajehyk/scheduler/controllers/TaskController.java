package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        Task task1 = taskRepository.save(task);
        return task1;
    }

    @GetMapping("/fetchTask/{id}")
    Task fetchTask(@PathVariable Long id) {
        Task fetchedTask = taskRepository.findById(id).get();
        return fetchedTask;
    }

    @GetMapping("/fetchAll/{telegramId}")
    ArrayList<Task> fetch(@PathVariable Long telegramId) {
        Task task = new Task(null, telegramId, null, null, null);
        Example example = Example.of(task);
        ArrayList<Task> taskList = (ArrayList<Task>) taskRepository.findAll(example);
        return taskList;
    }

    @PutMapping("/changeName")
    public void changeTaskName(@RequestBody Map<String, String> json) {
        Long taskId = Long.parseLong(json.get("taskId"));
        String taskName = json.get("taskName");
        Task fetchedTask = fetchTask(taskId);
        fetchedTask.setTaskName(taskName);
        taskRepository.save(fetchedTask);
    }

    @PutMapping("/changeDescription")
    public void changeTaskDescription(@RequestBody Map<String, String> json) {
        Long taskId = Long.parseLong(json.get("taskId"));
        String taskDescription = json.get("taskDescription");
        Task fetchedTask = fetchTask(taskId);
        fetchedTask.setDescription(taskDescription);
        taskRepository.save(fetchedTask);
    }
}
