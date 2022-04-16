package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.entities.TelegramUser;

public class Query {
    private TelegramUser telegramUser;
    private Task task;
    private String string;
    private String taskName;

    public Query() {}

    public Query(TelegramUser telegramUser, Task task, String string) {
        this.telegramUser = telegramUser;
        this.task = task;
        this.string = string;
    }

    public void setString(String string) {
        this.string = string;
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
}
