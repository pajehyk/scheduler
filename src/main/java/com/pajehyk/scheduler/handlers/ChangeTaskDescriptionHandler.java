package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.controllers.TelegramUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChangeTaskDescriptionHandler extends Handler {
    @Autowired
    TelegramUserController telegramUserController;
    @Autowired
    ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public void execute(Query obj) {
        Long telegramId = obj.getTelegramUser().getTelegramId();
        Long taskId = obj.getTelegramUser().getCurrentTaskId();
        String taskDescription = obj.getString();
        RestTemplate template = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        map.put("taskDescription", taskDescription);
        map.put("taskId", taskId.toString());
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map);
        template.put(url + "/task/changeDescription", httpEntity);
        obj.setString(null);
        changeTelegramUserHandlerHandler.execute(obj);
    }
}
