package com.virtusa.workouts.springworkout.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;

public interface AccountSystemGateway {
    @Gateway
    Message<String> invoke(Message<String> accountRequest);
}
