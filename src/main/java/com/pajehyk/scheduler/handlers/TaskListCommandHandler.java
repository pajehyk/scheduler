package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.TelegramUser;
import org.springframework.stereotype.Component;

@Component
public class TaskListCommandHandler implements CommandHandler {
    @Override
    public void execute(TelegramUser telegramUser, String command) {
        System.out.println(this.getClass());
    }
}
