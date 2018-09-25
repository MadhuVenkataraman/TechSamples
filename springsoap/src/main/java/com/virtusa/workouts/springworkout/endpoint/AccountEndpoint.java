package com.virtusa.workouts.springworkout.endpoint;

import com.virtusa.workouts.springworkout.types.Account;
import com.virtusa.workouts.springworkout.types.AccountRequest;
import com.virtusa.workouts.springworkout.types.AccountResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {
    @PayloadRoot(
            localPart = "accountRequest",
            namespace = "http://springworkout.workouts.virtusa.com/"

    )

public @ResponsePayload AccountResponse getAccountDetails(@RequestPayload AccountRequest accountRequest){
    AccountResponse accountResponse = new AccountResponse();

    Account account = new Account();
    account.setAccountId(200);
    account.setAccountType(accountRequest.getAccountType());
    account.setName(accountRequest.getName());
    accountResponse.setAccount(account);
    return  accountResponse;
}


}
