package com.pajehyk.scheduler;

import com.pajehyk.scheduler.handlers.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;

@Configuration
public class AppConfiguration {
    @Bean
    public SchedulerLongPollingBot schedulerLongPollingBot() {
        return new SchedulerLongPollingBot();
    }

    @Bean 
    TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        return new TelegramBotsApi(DefaultBotSession.class);
    }

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
    HashMap<String, Handler> handlersMap() {
        HashMap<String, Handler> hashMap = new HashMap<>();
        hashMap.put("/start", startHandler());
        hashMap.put("/addTask", addTaskHandler());
        hashMap.put("/changeName", changeTaskNameHandler());
        hashMap.put("/changeTaskName", changeTaskNameHandler());
        hashMap.put("/changeTaskDescription", changeTaskDescriptionHandler());
        return hashMap;
    }
}
