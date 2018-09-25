package com.virtusa.workouts.springworkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class AccountInterceptGateway  {
    @Autowired
    private AccountGateway accountWebService;
    public Message<String> transform(Message<String> message){
        return accountWebService.invoke(message);

    }
}
