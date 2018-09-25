package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountRequest;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class PayloadFilterService {
   public boolean filter(Message message){
        Object object = message.getPayload();
        System.out.print(object.toString());
       if(message.getPayload().getClass().equals(AccountRequest.class)){
           return  true;
       }else if(message.getPayload() instanceof String && !((String)message.getPayload()).contains("savings")){
           return true;
       }else if(message.getPayload() instanceof Byte[] && !((String)message.getPayload()).contains("savings")){
           return true;
       }else {
           return false;
       }


   }
}
