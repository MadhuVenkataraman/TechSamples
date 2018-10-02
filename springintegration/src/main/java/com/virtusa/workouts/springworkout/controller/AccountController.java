package com.virtusa.workouts.springworkout.controller;


import com.virtusa.workouts.springworkout.dto.ResponseDto;
import com.virtusa.workouts.springworkout.service.AccountGateway;
import com.virtusa.workouts.springworkout.service.AccountSystemGateway;
import com.virtusa.workouts.springworkout.types.AccountBatchRequest;
import com.virtusa.workouts.springworkout.types.AccountRequest;

import org.apache.tomcat.jni.Poll;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.RetryLoadBalancerInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.WebServiceMessage;
import zipkin2.Span;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class AccountController {

    private static final Logger LOG = Logger.getLogger(AccountController.class.getName());
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private AccountSystemGateway webService;

    @Autowired
    private RetryLoadBalancerInterceptor retryLoadBalancerInterceptor;

    @Autowired

    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
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

    @RequestMapping(path = "/accountbatchrequest")
    public ResponseDto getAccountBatchService(@RequestBody AccountBatchRequest accountBatchRequest) {

        LOG.log(Level.INFO, "account batch request is called....");
        MessageChannel messageChannel = applicationContext.getBean("splitterInputChannel", MessageChannel.class);

        Message message = new GenericMessage(accountBatchRequest);
        messageChannel.send(message);
        PollableChannel outputChannel = applicationContext.getBean("responseOutputChannel", PollableChannel.class);
        ResponseDto response = null;
        Message responseMessage = outputChannel.receive(30000);

        if(responseMessage !=null){

            response = (ResponseDto)responseMessage.getPayload();
        }
        System.out.println(response);
        return response;
    }

    @RequestMapping(path = "/sleuth/test")
    public ResponseEntity<String> sleuthTest(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("spring-soap");

        LOG.log(Level.INFO, "sleuth test....");
        RestTemplate restTemplate = new RestTemplate();
        List interceptors = restTemplate.getInterceptors();
        interceptors.add(retryLoadBalancerInterceptor);
        restTemplate.setInterceptors(interceptors);
        HttpHeaders httpHeaders = new HttpHeaders();
       String traceID =  MDC.get("X-B3-TraceId");
        String spanID =  MDC.get("X-B3-SpanId");
       System.out.print("trace Id:"+traceID+"---"+spanID);
        httpHeaders.set("x-b3-traceid",traceID);

        httpHeaders.set("x-b3-spanid",traceID);
        httpHeaders.set("TraceId",spanID);
        httpHeaders.set("x-b3-sampled","1");
        httpHeaders.set("X-B3-Flags","1");
       // httpHeaders.set("b3","100-200-1-300");
        HttpEntity<String> request = new HttpEntity<>("string", httpHeaders);

        return restTemplate.exchange("http://SPRING-SOAP/healthCheck",HttpMethod.GET,request,String.class);
    }

}
