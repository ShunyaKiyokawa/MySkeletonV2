package com.v2.myskeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class MySkeletonV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MySkeletonV2Application.class, args);
	}
	
	@RequestMapping("/")
	String hello(){
		return "Hello world";
	}
}
