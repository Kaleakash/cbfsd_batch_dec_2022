package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.repository")
@EntityScan(basePackages = "com.bean")		// @Entity classes enable in spring boot 
public class SpringBootWithDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithDockerApplication.class, args);
		System.out.println("Server up on port number 9090");
	}

}
