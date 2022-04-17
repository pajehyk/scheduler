package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class AddTaskHandler extends Handler{
    @Autowired
    private ChangeTelegramUserTaskHandler changeTelegramUserTaskHandler;
    @Autowired
    private ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public  void execute(Query obj) {
        Task task = obj.getTask();
        HttpEntity<Task> httpEntity = new HttpEntity<>(task);
        RestTemplate template = new RestTemplate();
        Task addedTask = template.postForEntity(url + "/task/add", httpEntity, Task.class).getBody();
        obj.setTaskId(addedTask.getId());
        obj.setString("/changeTaskName");
        changeTelegramUserTaskHandler.execute(obj);
        changeTelegramUserHandlerHandler.execute(obj);
    }
}
