package com.pajehyk.scheduler.handlers.task;

import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class TaskFetchAllHandler extends Handler {
    ArrayList<Map<String, Object>> tasks = new ArrayList<>();
    @Override
    public void execute(Query obj) {
        HashMap<String, String> json = new HashMap<>();
        json.put("telegramId", obj.getTelegramUser().getTelegramId().toString());
        RestTemplate template = new RestTemplate();
        tasks = template.getForEntity(url + "/task/fetchAll/{telegramId}", ArrayList.class, json).getBody();
    }

    @Override
    public String getMessage() {
        String returnString = "";
        for (int i = 0; i < tasks.size(); i++) {
            returnString += tasks.get(i).get("id").toString() + ". " + tasks.get(i).get("taskName") + '\n';
        }
        return returnString;
    }
}
