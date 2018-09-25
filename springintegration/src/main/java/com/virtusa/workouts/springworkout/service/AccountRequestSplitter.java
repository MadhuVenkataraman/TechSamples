package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountRequest;
import com.virtusa.workouts.springworkout.types.AccountBatchRequest;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRequestSplitter {
    @Splitter(inputChannel = "splitterInputChannel", outputChannel = "splitterOutputChannel")
    public List<AccountRequest> accountRequestFilter(AccountBatchRequest accountBatchRequest){
        return accountBatchRequest.getAccountRequests();
    }
}
