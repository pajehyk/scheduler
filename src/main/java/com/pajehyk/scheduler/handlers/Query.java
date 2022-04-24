package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.entities.TelegramUser;

public class Query {
    private TelegramUser telegramUser;
    private Task task;
    private String string;
    private String taskName;
    private Long taskId;
    private Long taskNum;

    public Query() {}

    public Query(TelegramUser telegramUser, Task task, String string) {
        this.telegramUser = telegramUser;
        this.task = task;
        this.string = string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setTelegramUser(TelegramUser telegramUser) {
        this.telegramUser = telegramUser;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getString() {
        return string;
    }

    public String getTaskName() {
        return taskName;
    }

    public Task getTask() {
        return task;
    }

    public TelegramUser getTelegramUser() {
        return telegramUser;
    }

    public Long getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(Long taskNum) {
        this.taskNum = taskNum;
    }
}
