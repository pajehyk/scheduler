package com.pajehyk.scheduler.handlers;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class StartHandler extends Handler{
    public <T> void execute(T obj) {
        HttpEntity<T> httpEntity = new HttpEntity<>(obj);
        RestTemplate template = new RestTemplate();
        template.postForLocation(url + "/user/start", httpEntity);
    }

    public StartHandler() {

    }
}
