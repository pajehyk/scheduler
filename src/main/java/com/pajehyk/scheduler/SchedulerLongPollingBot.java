package com.pajehyk.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.pajehyk.scheduler.entities.TelegramUser;

import com.pajehyk.scheduler.handlers.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class SchedulerLongPollingBot extends TelegramLongPollingBot {
    private Properties properties = new Properties();
    private String botToken;
    private String botName;
    @Autowired
    private HashMap<String, Handler> handlersMap;



    SchedulerLongPollingBot() {
        try (InputStream is = new FileInputStream(new File("src/main/resources/bot.properties"))) {
            properties.load(is);
            botToken = properties.getProperty("bot.token");
            botName = properties.getProperty("bot.name");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        Message updateMessage = update.getMessage();
        String messageText = updateMessage.getText();
        User user = updateMessage.getFrom();
        Long taskId;
        Long userId = user.getId();
        TelegramUser telegramUser = new TelegramUser(user);
        handlersMap.get(messageText).execute(telegramUser);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
    
}
