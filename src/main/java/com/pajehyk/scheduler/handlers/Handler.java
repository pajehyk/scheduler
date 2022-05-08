package com.pajehyk.scheduler.handlers;

import org.springframework.web.client.RestTemplate;

public abstract class Handler {
    protected String url = "http://localhost:8080";
    protected RestTemplate restTemplate = new RestTemplate();
    public abstract Query execute(Query obj);
    public String getMessage() {
        return null;
    }
}
