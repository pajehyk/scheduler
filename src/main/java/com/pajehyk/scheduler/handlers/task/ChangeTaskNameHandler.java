package com.pajehyk.scheduler.handlers.task;

import com.pajehyk.scheduler.controllers.TelegramUserController;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChangeTaskNameHandler extends Handler {
    @Autowired
    TelegramUserController telegramUserController;
    @Autowired
    ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public void execute(Query obj) {
        Long telegramId = obj.getTelegramUser().getTelegramId();
        Long taskId = obj.getTelegramUser().getCurrentTaskId();
        String taskName = obj.getString();
        RestTemplate template = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        map.put("taskName", taskName);
        map.put("taskId", taskId.toString());
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map);
        template.put(url + "/task/changeName", httpEntity);
        obj.setString("/changeTaskDescription");
        changeTelegramUserHandlerHandler.execute(obj);
    }

    @Override
    public String getMessage() {
        return "Enter description of your task: ";
    }
}
