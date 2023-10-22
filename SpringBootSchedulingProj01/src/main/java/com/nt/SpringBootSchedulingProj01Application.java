package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootSchedulingProj01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulingProj01Application.class, args);
		System.out.println("App Started at:: "+new Date());
	}

}
