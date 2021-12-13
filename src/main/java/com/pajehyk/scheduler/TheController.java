package com.pajehyk.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheController {
    @Autowired
    private SchedulerLongPollingBot schedulerLongPollingBot;

    @GetMapping("/home")
    public String home() {
        return schedulerLongPollingBot.getBotUsername();
    }
}
