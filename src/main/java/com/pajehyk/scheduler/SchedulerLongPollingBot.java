package com.pajehyk.scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.Clock;
import java.util.Properties;

import com.pajehyk.scheduler.controllers.TaskController;
import com.pajehyk.scheduler.controllers.TaskInListController;
import com.pajehyk.scheduler.controllers.TaskListController;
import com.pajehyk.scheduler.controllers.TelegramUserController;
import com.pajehyk.scheduler.entities.TaskInList;
import com.pajehyk.scheduler.entities.TelegramUser;

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
    private TelegramUserController telegramUserController;
    @Autowired
    private TaskController taskController;
    @Autowired
    private TaskInListController taskInListController;
    @Autowired
    private TaskListController taskListController;


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
        switch (messageText) {
            case "/start":
                telegramUserController.addTelegramUser(new TelegramUser(user.getId(), user.getFirstName(),
                    user.getLastName(), user.getUserName(), new Date(Clock.systemDefaultZone().millis()),
                        Status.MENU));
                break;
            case "/createTask":
            default:
                System.out.println("Default case.");
                break;
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
