package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.entities.UserTasks;
import com.pajehyk.scheduler.repositories.UserTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class UserTasksController {
    @Autowired
    UserTasksRepository userTasksRepository;
    @Autowired
    MaxTaskNumberController maxTaskNumberController;
    @Autowired
    TaskController taskController;

    @PostMapping("/add")
    public void add(@RequestBody UserTasks userTasks) {
        userTasksRepository.save(userTasks);
    }

    @GetMapping("/get/{userId}")
    public List<UserTasks> get(@PathVariable long userId) {
        UserTasks userTasks = new UserTasks((Long) null, userId, (Long) null, (Long) null);
        List<UserTasks> list = userTasksRepository.findAll(Example.of(userTasks));
        return list;
    }

    @GetMapping("/getList/{userId}")
    public List<UserTasks> getList(@PathVariable Long userId) {
        return userTasksRepository.getUserTasksById(userId);
    }

    public Long getTaskId(Long telegramId, Long taskNum) {
        UserTasks userTasks = new UserTasks(telegramId, taskNum);
        UserTasks fetchedUserTasks = userTasksRepository.findOne(Example.of(userTasks)).get();
        return fetchedUserTasks.getTaskId();
    }

    @PutMapping("/complete/{telegramId}/{taskNum}")
    public void completeTask(@PathVariable Long telegramId, @PathVariable Long taskNum) {
        Long taskId = getTaskId(telegramId, taskNum);
        userTasksRepository.completeTaskByTelegramIdTaskNum(telegramId, taskNum);
        userTasksRepository.updateTaskNumsByTelegramIdTaskNum(telegramId, taskNum);
        maxTaskNumberController.decrement(telegramId);
        taskController.completeTask(taskId);
    }
}
