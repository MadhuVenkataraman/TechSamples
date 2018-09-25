package com.virtusa.workouts.springworkout.service;

import org.slf4j.Logger;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AccountTransformService {

    public Message transform(Message message){
        String payload = (String)message.getPayload();
        if(payload != null){
            if(payload.contains("credit")){
                return new GenericMessage("from credit");
            }else  if(payload.contains("savings")){
                return new GenericMessage("from savings");
            }else  if(payload.contains("spend")){
                return new GenericMessage("from spend");
            }else  if(payload.contains("grow")){
                return new GenericMessage("from grow");
            }
        }
        return new GenericMessage("from transform");
    }
}
