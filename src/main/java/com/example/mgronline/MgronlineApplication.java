package com.example.mgronline;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MgronlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgronlineApplication.class, args);
	}

}
