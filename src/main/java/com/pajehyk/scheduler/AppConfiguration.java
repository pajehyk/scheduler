package com.pajehyk.scheduler;

import com.pajehyk.scheduler.handlers.*;
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
    public SchedulerLongPollingBot schedulerLongPollingBot() {
        return new SchedulerLongPollingBot();
    }

    @Bean 
    TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
/*
    @Bean
    Handler startHandler() {
        return new StartHandler();
    }
    @Bean
    Handler addTaskHandler() {
        return new AddTaskHandler();
    }
    @Bean
    Handler changeTaskNameHandler() {
        return new ChangeTaskNameHandler();
    }
    @Bean
    Handler changeTaskDescriptionHandler() {
        return new ChangeTaskDescriptionHandler();
    }
    @Bean
    Handler changeTelegramUserTaskHandler() {
        return new ChangeTelegramUserTaskHandler();
    }
 */
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
