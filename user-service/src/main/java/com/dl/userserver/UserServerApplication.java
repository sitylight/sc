package com.dl.userserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserServerApplication {

	public static void main(final String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}

}
