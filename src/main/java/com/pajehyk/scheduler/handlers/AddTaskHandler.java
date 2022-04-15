package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.Task;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AddTaskHandler extends Handler{
    public  void execute(Query obj) {
        Task task = obj.getTask();
        HttpEntity<Task> httpEntity = new HttpEntity<>(task);
        RestTemplate template = new RestTemplate();
        template.postForLocation(url + "/task/add", httpEntity);
    }
}
