package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.controllers.TelegramUserController;
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
        telegramUserController.changeTelegramUserCurrentHandler(telegramId, "/changeTaskDescription");
    }
}