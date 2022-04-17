package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.Status;
import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/user")
public class TelegramUserController {
    @Autowired
    TelegramUserRepository telegramUserRepository;

    @PostMapping("/start")
    public void addTelegramUser(@RequestBody TelegramUser telegramUser){
        telegramUserRepository.save(telegramUser);
    }
    public TelegramUser fetchTelegramUser(long telegramId) {
        TelegramUser telegramUser = new TelegramUser(telegramId);
        return telegramUserRepository.findOne(Example.of(telegramUser)).get();
    }
    @PutMapping("/changeTask")
    public void changeTelegramUserCurrentTask(@RequestBody Map<String, String> json) {
        Long telegramId = Long.parseLong(json.get("telegramId"));
        Long currentTaskId = Long.parseLong(json.get("taskId"));
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        telegramUser.setCurrentTaskId(currentTaskId);
        telegramUserRepository.save(telegramUser);
    }
    @PutMapping("/changeHandler")
    public void changeTelegramUserCurrentHandler(@RequestBody Map <String, String> json) {
        Long telegramId = Long.parseLong(json.get("telegramId"));
        String handlerString = json.get("handlerString");
        TelegramUser telegramUser = fetchTelegramUser(telegramId);
        telegramUser.setCurrentHandler(handlerString);
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
