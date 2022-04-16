package com.pajehyk.scheduler.handlers;

import com.pajehyk.scheduler.entities.TelegramUser;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class StartHandler extends Handler{
    public StartHandler() {}

    @Override
    public void execute(Query obj) {
        TelegramUser telegramUser = obj.getTelegramUser();
        HttpEntity<TelegramUser> httpEntity = new HttpEntity<>(telegramUser);
        RestTemplate template = new RestTemplate();
        template.postForLocation(url + "/user/start", httpEntity);
    }
}
