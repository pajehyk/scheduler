package com.pajehyk.scheduler.handlers.maxtasknumber;

import com.pajehyk.scheduler.entities.MaxTaskNumber;
import com.pajehyk.scheduler.handlers.Handler;
import com.pajehyk.scheduler.handlers.Query;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

@Component
public class AddMaxTaskNumberHandler extends Handler {
    @Override
    public Query execute(Query obj) {
        MaxTaskNumber maxTaskNumber = obj.getMaxTaskNumber();
        HttpEntity<MaxTaskNumber> httpEntity = new HttpEntity<>(maxTaskNumber);
        restTemplate.postForEntity(url + "/number/add", httpEntity, MaxTaskNumber.class);
        return obj;
    }
}
