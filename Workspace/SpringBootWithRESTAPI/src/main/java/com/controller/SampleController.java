package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping(value = "say")
	public String sayHello() {
		return "Welcome to My Simple Spring REST API Call";
	}
}
