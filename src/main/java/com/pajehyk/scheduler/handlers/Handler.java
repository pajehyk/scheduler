package com.pajehyk.scheduler.handlers;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class Handler {
    String url = "http://localhost:8080";
    public abstract void execute(Query obj);
    public String getMessage() {
        return null;
    }
}
