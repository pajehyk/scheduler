package com.pajehyk.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.pajehyk.scheduler.controllers.TelegramUserController;
import com.pajehyk.scheduler.entities.Task;
import com.pajehyk.scheduler.entities.TelegramUser;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class SchedulerLongPollingBot extends TelegramLongPollingBot {
    @Autowired
    private TelegramUserRepository telegramUserRepository;
    @Autowired
    private TelegramUserController telegramUserController;
    private Properties properties = new Properties();
    private String botToken;
    private String botName;
    @Autowired
    @Qualifier("handlersMap")
    private HashMap<String, Handler> handlersMap;
    @Autowired
    BotProperties botProperties;



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
        TelegramUser telegramUser = new TelegramUser(user);
        Task task = new Task(null, telegramUser.getTelegramId(), null, null, null);
        Query query = new Query(telegramUser, task, "");
        String text;
        System.out.println(botProperties.getName());
        if (messageText.startsWith("/")) {
            handlersMap.get(messageText).execute(query);
            text = handlersMap.get(messageText).getMessage();
        } else {
            Long currentTask = telegramUserController.getCurrentTask(telegramUser.getTelegramId());
            TelegramUser fetchedUser = telegramUserController.fetchTelegramUser(telegramUser.getTelegramId());
            String currentHandler = fetchedUser.getCurrentHandler();
            query.setString(messageText);
            query.setTelegramUser(fetchedUser);
            handlersMap.get(currentHandler).execute(query);
            text = handlersMap.get(currentHandler).getMessage();
        }
        if (text != null) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(updateMessage.getChatId().toString());
            sendMessage.setText(text);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
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
