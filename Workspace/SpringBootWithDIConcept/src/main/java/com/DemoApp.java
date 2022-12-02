package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoApp.class, args);
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com");
		ac.refresh();
		
		Employee emp = (Employee)ac.getBean("employee");
		//emp.display();
		System.out.println(emp);   // it will call toString method
//		Address add = (Address)ac.getBean("address");
//		System.out.println(add);
	}

}
