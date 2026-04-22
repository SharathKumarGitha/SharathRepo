package com.task;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleJavaTaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleJavaTaskProjectApplication.class, args);
		
		System.out.println("this is task project application with jwt security....");
	}
	

}
