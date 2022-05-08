package com.pajehyk.scheduler.handlers.usertasks;

import com.pajehyk.scheduler.entities.UserTasks;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ShowTasksHandler extends Handler {
    private List<Map<String, Object>> list;
    @Override
    public Query execute(Query obj) {
        Long userId = obj.getTelegramUser().getTelegramId();
        list = restTemplate.getForObject(url + "/tasks/getList/" + userId, List.class);
        return obj;
    }

    @Override
    public String getMessage() {
        String returnString = "";
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> taskMap = (Map<String, Object>)list.get(i).get("task");
            returnString += list.get(i).get("taskNum").toString() + ". " + taskMap.get("taskName") + '\n';
        }
        return returnString;
    }
}
