package com.pajehyk.scheduler.handlers;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChangeTelegramUserHandlerHandler extends Handler {
    @Override
    public void execute(Query obj) {
        Long telegramId = obj.getTelegramUser().getTelegramId();
        String handlerString = obj.getString();
        RestTemplate template = new RestTemplate();
        HashMap<String, String> map = new HashMap<>();
        map.put("telegramId", telegramId.toString());
        map.put("handlerString", handlerString);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map);
        template.put(url + "/user/changeHandler", httpEntity);
    }
}
