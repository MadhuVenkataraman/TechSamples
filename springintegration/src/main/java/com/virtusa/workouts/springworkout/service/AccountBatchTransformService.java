package com.virtusa.workouts.springworkout.service;

import com.virtusa.workouts.springworkout.types.AccountRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AccountBatchTransformService {
    @Autowired
    private ApplicationContext applicationContext;
    public void request(List<AccountRequest> accountRequestList){
        MessageChannel messageChannel = applicationContext.getBean("inputChannel", MessageChannel.class);

        if(!CollectionUtils.isEmpty(accountRequestList)) {
            for (AccountRequest accountRequest: accountRequestList ) {
                sendRequest(messageChannel, accountRequest);
            }

        }
    }

    public Message<String> request(Message<AccountRequest> accountRequestMessage){
        AccountRequest accountRequest = accountRequestMessage.getPayload();
        String message =
                "      <accountRequest xmlns=\"http://springworkout.workouts.virtusa.com/\">\n" +
                        "      \t<name>" + accountRequest.getName() + "</name>\n" +
                        "      \t<accountType>" + accountRequest.getAccountType() + "</accountType>\n" +
                        "      </accountRequest>\n";
        return new GenericMessage<>(message);
    }
    private void sendRequest(MessageChannel messageChannel , AccountRequest accountRequest) {
        String message =
                "      <accountRequest xmlns=\"http://springworkout.workouts.virtusa.com/\">\n" +
                        "      \t<name>" + accountRequest.getName() + "</name>\n" +
                        "      \t<accountType>" + accountRequest.getAccountType() + "</accountType>\n" +
                        "      </accountRequest>\n";
        messageChannel.send(new GenericMessage<>(message));
    }
}
