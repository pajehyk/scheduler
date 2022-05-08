package com.pajehyk.scheduler.handlers.usertasks;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import com.pajehyk.scheduler.handlers.telegramuser.ChangeTelegramUserHandlerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

@Component
public class CompleteTaskHandler extends Handler {
    @Autowired
    ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public Query execute(Query obj) {
        Long taskNum = Long.parseLong(obj.getString());
        Long telegramId = obj.getTelegramUser().getTelegramId();
        HttpEntity<Object> httpEntity = new HttpEntity<>(null);
        restTemplate.put(url + "/tasks/complete/" + telegramId + "/" + taskNum, httpEntity);
        obj.setString("");
        changeTelegramUserHandlerHandler.execute(obj);
        return obj;
    }
}
