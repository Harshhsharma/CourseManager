package com.example.coursemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagerApplication.class, args);
	}

}
