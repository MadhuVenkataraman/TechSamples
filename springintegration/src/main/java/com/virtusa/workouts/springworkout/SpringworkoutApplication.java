package com.virtusa.workouts.springworkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@EnableEurekaClient
@ImportResource("classpath:/META-INF/integration-beans.xml")
public class SpringworkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringworkoutApplication.class, args);
	}
}
