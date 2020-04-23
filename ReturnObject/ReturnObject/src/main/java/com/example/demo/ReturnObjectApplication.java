package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class ReturnObjectApplication {

	@RequestMapping("/")
	@ResponseBody
	String homepage(){
		return "Welcome to the home page.";
	}

	public static void main(String[] args) {
		SpringApplication.run(ReturnObjectApplication.class, args);
	}

}
