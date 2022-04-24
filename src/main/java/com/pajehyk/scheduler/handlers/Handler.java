package com.pajehyk.scheduler.handlers;

public abstract class Handler {
    protected String url = "http://localhost:8080";
    public abstract Query execute(Query obj);
    public String getMessage() {
        return null;
    }
}
