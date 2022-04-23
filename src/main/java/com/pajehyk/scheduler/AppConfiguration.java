package com.pajehyk.scheduler;

import com.pajehyk.scheduler.handlers.*;
import com.pajehyk.scheduler.handlers.task.AddTaskHandler;
import com.pajehyk.scheduler.handlers.task.ChangeTaskDescriptionHandler;
import com.pajehyk.scheduler.handlers.task.ChangeTaskNameHandler;
import com.pajehyk.scheduler.handlers.task.TaskFetchAllHandler;
import com.pajehyk.scheduler.handlers.telegramuser.ChangeTelegramUserTaskHandler;
import com.pajehyk.scheduler.handlers.telegramuser.StartHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;

@Configuration
public class AppConfiguration {
    @Autowired
    AddTaskHandler addTaskHandler;
    @Autowired
    ChangeTelegramUserTaskHandler changeTelegramUserTaskHandler;
    @Autowired
    ChangeTaskNameHandler changeTaskNameHandler;
    @Autowired
    ChangeTaskDescriptionHandler changeTaskDescriptionHandler;
    @Autowired
    StartHandler startHandler;
    @Autowired
    TaskFetchAllHandler taskFetchAllHandler;

    @Bean 
    TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        return new TelegramBotsApi(DefaultBotSession.class);
    }

    @Bean
    HashMap<String, Handler> handlersMap() {
        HashMap<String, Handler> hashMap = new HashMap<>();
        hashMap.put("/start", startHandler);
        hashMap.put("/addTask", addTaskHandler);
        hashMap.put("/changeTaskName", changeTaskNameHandler);
        hashMap.put("/changeTaskDescription", changeTaskDescriptionHandler);
        hashMap.put("/changeTelegramUserTask", changeTelegramUserTaskHandler);
        hashMap.put("/showTasks", taskFetchAllHandler);
        return hashMap;
    }
}
