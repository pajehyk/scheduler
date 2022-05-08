package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.handlers.telegramuser.ChangeTelegramUserHandlerHandler;
import com.pajehyk.scheduler.handlers.telegramuser.ChangeTelegramUserTaskHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompleteHandler extends Handler {
    @Autowired
    ChangeTelegramUserHandlerHandler changeTelegramUserHandlerHandler;
    @Override
    public Query execute(Query obj) {
        obj.setString("/completeTaskHandler");
        changeTelegramUserHandlerHandler.execute(obj);
        return obj;
    }

    @Override
    public String getMessage() {
        return "Enter number of task: ";
    }
}
