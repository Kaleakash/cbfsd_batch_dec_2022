package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages ="com.repository")
@EntityScan(basePackages = "com.entity")
public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DemoApp.class, args);
		System.out.println("Server up");
	}

}
