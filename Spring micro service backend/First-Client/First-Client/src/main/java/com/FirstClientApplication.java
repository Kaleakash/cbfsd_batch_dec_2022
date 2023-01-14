package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com")
@EnableEurekaClient
public class FirstClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstClientApplication.class, args);
		System.out.println("First client up");
	}

}
