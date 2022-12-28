package com.lcwd.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.repositories.UserRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {
	
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(UserServiceApplication.class, args);
		
	}

}
