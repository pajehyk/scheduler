package com.pajehyk.scheduler.handlers.task;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.handlers.telegramuser.ChangeTelegramUserTaskHandler;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddTaskHandler extends Handler {
    @Autowired
    private ChangeTelegramUserTaskHandler changeTelegramUserTaskHandler;
    @Autowired
    private ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public Query execute(Query obj) {
        Task task = obj.getTask();
        HttpEntity<Task> httpEntity = new HttpEntity<>(task);
        RestTemplate template = new RestTemplate();
        Task addedTask = template.postForEntity(url + "/task/add", httpEntity, Task.class).getBody();
        obj.setTaskId(addedTask.getId());
        obj.setString("/changeTaskName");
        changeTelegramUserTaskHandler.execute(obj);
        changeTelegramUserHandlerHandler.execute(obj);
        return obj;
    }

    @Override
    public String getMessage() {
        return "Enter name of your task: ";
    }
}
