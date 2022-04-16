package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.Status;
import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class TelegramUserController {
    @Autowired
    TelegramUserRepository telegramUserRepository;

    @PostMapping("/start")
    public void addTelegramUser(@RequestBody TelegramUser telegramUser){
        telegramUserRepository.save(telegramUser);
    }
    public void changeTelegramUserStatus(long telegramId, Status status) {
        TelegramUser fetchedUser = this.fetchTelegramUser(telegramId);
        fetchedUser.setStatus(status);
        telegramUserRepository.save(fetchedUser);
    }
    public TelegramUser fetchTelegramUser(long telegramId) {
        TelegramUser telegramUser = new TelegramUser(telegramId);
        return telegramUserRepository.findOne(Example.of(telegramUser)).get();
    }
    public void changeTelegramUserCurrentTask(long telegramId, long currentTaskId) {
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        telegramUser.setCurrentTaskId(currentTaskId);
        telegramUserRepository.save(telegramUser);
    }
    public void changeTelegramUserCurrentHandler(long telegramId, String currentHandlerString) {
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        telegramUser.setCurrentHandler(currentHandlerString);
        telegramUserRepository.save(telegramUser);
    }
    public Status getTelegramUserStatus(long telegramId) {
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        return telegramUser.getStatus();
    }
    public Long getCurrentTask(long telegramId) {
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        return telegramUser.getCurrentTaskId();
    }
}
