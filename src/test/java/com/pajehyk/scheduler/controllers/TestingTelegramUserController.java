package com.pajehyk.scheduler.controllers;

import com.pajehyk.scheduler.Status;
import com.pajehyk.scheduler.entities.TelegramUser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@SpringBootTest
public class TestingTelegramUserController {
    @Autowired
    private TelegramUserController telegramUserController;
    @Test
    @Rollback
    @Transactional
    public void testingFetchTelegramUser() {
        long telegramId = 123123123L;
        TelegramUser telegramUser = new TelegramUser(telegramId, "f",
                "l", "u", new Date(1), Status.MENU, -1L);
        telegramUserController.addTelegramUser(telegramUser);
        TelegramUser fetchedUser = telegramUserController.fetchTelegramUser(telegramId);
        assertTrue(fetchedUser.equals(telegramUser));
    }
}
