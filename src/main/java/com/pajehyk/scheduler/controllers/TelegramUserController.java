package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.Status;
import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.repositories.TelegramUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TelegramUserController {
    @Autowired
    TelegramUserRepository telegramUserRepository;

    @GetMapping("/start") 
    public void addTelegramUser(TelegramUser telegramUser){
        telegramUserRepository.save(telegramUser);
    }

    public void changeTelegramUserStatus(TelegramUser telegramUser, Status status) {
        Example<TelegramUser> example = Example.of(telegramUser);
        TelegramUser foundUser = telegramUserRepository.findOne(example).get();
        foundUser.setStatus(status);
    }
}
