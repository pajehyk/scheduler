package com.pajehyk.scheduler.handlers.usertasks;

import com.pajehyk.scheduler.entities.UserTasks;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import com.pajehyk.scheduler.handlers.maxtasknumber.GetTaskNumHandler;
import com.pajehyk.scheduler.handlers.maxtasknumber.IncrementHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddHandler extends Handler {
    @Autowired
    private GetTaskNumHandler getTaskNumHandler;
    @Autowired
    private IncrementHandler incrementHandler;

    @Override
    public Query execute(Query obj) {
        Long taskId = obj.getTaskId();
        Long userId = obj.getTelegramUser().getTelegramId();
        Long taskNum = getTaskNumHandler.execute(obj).getTaskNum();
        UserTasks userTasks = new UserTasks(userId, taskId, taskNum, obj.getTask());
        HttpEntity<UserTasks>  httpEntity = new HttpEntity<>(userTasks);
        System.out.println(userTasks.getTaskId());
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url + "/tasks/add", httpEntity, UserTasks.class);
        incrementHandler.execute(obj);
        return obj;
    }
}
