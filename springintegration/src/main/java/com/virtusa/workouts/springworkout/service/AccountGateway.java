package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountRequest;
import com.virtusa.workouts.springworkout.types.AccountResponse;
import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;

public interface AccountGateway {
    @Gateway
    Message<String> invoke(Message<String> accountRequest);
}
