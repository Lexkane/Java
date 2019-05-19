package com.company.lexkane;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

}
