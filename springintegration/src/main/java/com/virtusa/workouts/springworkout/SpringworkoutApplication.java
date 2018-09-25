package com.virtusa.workouts.springworkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/META-INF/integration-beans.xml")
public class SpringworkoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringworkoutApplication.class, args);
	}
}
