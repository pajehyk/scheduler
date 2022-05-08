package com.pajehyk.scheduler.handlers.telegramuser;

import com.pajehyk.scheduler.entities.MaxTaskNumber;
import com.pajehyk.scheduler.entities.TelegramUser;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import com.pajehyk.scheduler.handlers.maxtasknumber.AddMaxTaskNumberHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartHandler extends Handler {
    @Autowired
    AddMaxTaskNumberHandler addMaxTaskNumberHandler;
    public StartHandler() {}

    @Override
    public Query execute(Query obj) {
        TelegramUser telegramUser = obj.getTelegramUser();
        HttpEntity<TelegramUser> httpEntity = new HttpEntity<>(telegramUser);
        RestTemplate template = new RestTemplate();
        TelegramUser addedTelegramUser = template.postForEntity(url + "/user/start",
                httpEntity, TelegramUser.class).getBody();
        obj.setMaxTaskNumber(new MaxTaskNumber(addedTelegramUser.getTelegramId()));
        addMaxTaskNumberHandler.execute(obj);
        return obj;
    }
}
