package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class TestingHandlers {
    @Autowired
    private HashMap<Status, CommandHandler> statusCommandHandlerHashMap;
    @Test
    public void testMap() {
        statusCommandHandlerHashMap.get(Status.MENU).execute(null, "asd");
        statusCommandHandlerHashMap.get(Status.TASKS).execute(null, "asd");
    }
}
