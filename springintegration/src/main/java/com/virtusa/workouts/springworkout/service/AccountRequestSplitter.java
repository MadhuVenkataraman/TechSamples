package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountRequest;
import com.virtusa.workouts.springworkout.types.AccountBatchRequest;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountRequestSplitter {

    public List<AccountRequest> accountRequestSplitter(AccountBatchRequest accountBatchRequest){
        return accountBatchRequest.getAccountBatchRequest();
    }
}
