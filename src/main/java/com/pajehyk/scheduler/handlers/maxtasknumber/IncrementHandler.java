package com.pajehyk.scheduler.handlers.maxtasknumber;

import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IncrementHandler extends Handler {
    @Override
    public Query execute(Query obj) {
        Long userId = obj.getTelegramUser().getTelegramId();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(url + "/number/incr/" + userId, Long.class);
        return null;
    }
}
