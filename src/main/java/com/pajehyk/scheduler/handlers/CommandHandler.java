package com.pajehyk.scheduler.handlers;


import com.pajehyk.scheduler.controllers.TaskController;
import com.pajehyk.scheduler.entities.TelegramUser;
import org.springframework.beans.factory.annotation.Autowired;

public interface CommandHandler {
    public void execute(TelegramUser telegramUser, String command);
}
