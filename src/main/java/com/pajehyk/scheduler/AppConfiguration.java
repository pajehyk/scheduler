package com.pajehyk.scheduler;

import com.pajehyk.scheduler.handlers.CommandHandler;
import com.pajehyk.scheduler.handlers.MenuCommandHandler;
import com.pajehyk.scheduler.handlers.TaskCommandHandler;
import com.pajehyk.scheduler.handlers.TaskListCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
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
    @DependsOn({"menuCommandHandler", "taskCommandHandler", "taskListCommandHandler"})
    public HashMap<Status, CommandHandler>
    statusCommandHandlerHashMap(@Autowired MenuCommandHandler menuCommandHandler,
                                @Autowired TaskCommandHandler taskCommandHandler,
                                @Autowired TaskListCommandHandler taskListCommandHandler) {
        HashMap<Status, CommandHandler> map = new HashMap<>();
        map.put(Status.MENU, menuCommandHandler);
        map.put(Status.TASKS, taskCommandHandler);
        return map;
    }

}
