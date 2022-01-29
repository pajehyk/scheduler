package com.pajehyk.scheduler;

import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    TelegramUserRepository telegramUserRepository;

    @GetMapping("/start") 
    public void addTelegramUser(TelegramUser telegramUser){
        telegramUserRepository.save(telegramUser);
    }
}
