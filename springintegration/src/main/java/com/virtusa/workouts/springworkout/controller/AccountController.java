package com.virtusa.workouts.springworkout.controller;

import com.virtusa.workouts.springworkout.dto.ResponseDto;
import com.virtusa.workouts.springworkout.service.AccountGateway;
import com.virtusa.workouts.springworkout.service.AccountSystemGateway;
import com.virtusa.workouts.springworkout.types.AccountRequest;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private AccountSystemGateway webService;
    @RequestMapping("/accountservice")
    public ResponseDto loadMessage(@RequestParam("name") String username,@RequestParam("accountType") String accountType){
        DirectChannel messageChannel = applicationContext.getBean("inputChannel", DirectChannel.class);
        AccountRequest request = new AccountRequest();
        request.setName("Hi Shiva");
        String message =
                "      <accountRequest xmlns=\"http://springworkout.workouts.virtusa.com/\">\n" +
                "      \t<name>"+username+"</name>\n" +
                "      \t<accountType>"+accountType+"</accountType>\n" +
                "      </accountRequest>\n";
        messageChannel.send(new GenericMessage<>(message));

        //Direct call from service without queue channel
        // Message<String> outputMessage = webService.invoke(new GenericMessage<>(message));
        //System.out.print(outputMessage.toString());
        ResponseDto response = null;
        PollableChannel outputChannel = applicationContext.getBean("outputChannel", PollableChannel.class);

        Message responseMessage = outputChannel.receive(1000);

        if(responseMessage !=null){

          response = (ResponseDto)responseMessage.getPayload();
        }
        System.out.println(response);
        return response;
    }
}
