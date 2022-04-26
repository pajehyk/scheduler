package com.pajehyk.scheduler.handlers.task;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.http.HttpEntity;

public class CompleteTaskHandler extends Handler {
    @Override
    public Query execute(Query obj) {
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);
        Long taskId = obj.getTaskId();
        restTemplate.put(url + "/task/complete/" + taskId, httpEntity, Object.class);
        return obj;
    }
}
