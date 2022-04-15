package com.pajehyk.scheduler;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.StartHandler;
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
    HashMap<String, Handler> handlersMap() {
        HashMap<String, Handler> hashMap = new HashMap<>();
        hashMap.put("/start", startHandler());
        return hashMap;
    }
}
