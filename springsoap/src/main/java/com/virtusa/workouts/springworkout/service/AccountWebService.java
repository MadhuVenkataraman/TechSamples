package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountResponse;
import org.springframework.integration.annotation.Gateway;

public interface AccountWebService {
    @Gateway
    String invoke(String accountRequest);
}
