package com.virtusa.workouts.springworkout.controller;

import com.virtusa.workouts.springworkout.service.AccountWebService;
import com.virtusa.workouts.springworkout.types.AccountRequest;
import com.virtusa.workouts.springworkout.types.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private AccountWebService webService;
    @RequestMapping("/accountservice")
    public String loadMessage(){

        MessageChannel messageChannel = applicationContext.getBean("requestChannel", MessageChannel.class);
        AccountRequest request = new AccountRequest();
        request.setName("Hi Shiva");
        String message =
                "      <accountRequest xmlns=\"http://springworkout.workouts.virtusa.com/\">\n" +
                "      \t<name>Shiva</name>\n" +
                "      </accountRequest>\n";
       // messageChannel.send(new GenericMessage<>(message));
        MessageChannel responseChannel = applicationContext.getBean("responseChannel", MessageChannel.class);
        String response = webService.invoke(message);
        System.out.println(response);
        return response;
    }
}
