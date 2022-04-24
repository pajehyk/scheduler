package com.pajehyk.scheduler.handlers.telegramuser;

import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartHandler extends Handler {
    public StartHandler() {}

    @Override
    public Query execute(Query obj) {
        TelegramUser telegramUser = obj.getTelegramUser();
        HttpEntity<TelegramUser> httpEntity = new HttpEntity<>(telegramUser);
        RestTemplate template = new RestTemplate();
        template.postForLocation(url + "/user/start", httpEntity);
        return obj;
    }
}
