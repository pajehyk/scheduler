package com.pajehyk.scheduler;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ComponentBot {
    @Autowired
    private SchedulerLongPollingBot schedulerLongPollingBot;
    @Autowired
    private TelegramBotsApi telegramBotsApi;

    @PostConstruct
    public void registerBot() throws TelegramApiException {
        telegramBotsApi.registerBot(schedulerLongPollingBot);
    }
}
