package com.virtusa.eureka.eurekaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EurekaAppController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/apps1")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            ) {
        return this.discoveryClient.getInstances("shiva");
    }
}
