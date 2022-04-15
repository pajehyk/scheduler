package com.pajehyk.scheduler.handlers;

public abstract class Handler {
    String url = "http://localhost:8080";
    public abstract <T> void execute(T obj);
}
