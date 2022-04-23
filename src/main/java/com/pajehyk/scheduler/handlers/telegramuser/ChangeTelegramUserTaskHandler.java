package com.pajehyk.scheduler.handlers.telegramuser;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChangeTelegramUserTaskHandler extends Handler {
    @Override
    public void execute(Query obj) {
        Long telegramId = obj.getTelegramUser().getTelegramId();
        Long taskId = obj.getTaskId();
        RestTemplate template = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        map.put("telegramId", telegramId.toString());
        map.put("taskId", taskId.toString());
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map);
        template.put(url + "/user/changeTask", httpEntity);
    }
}
