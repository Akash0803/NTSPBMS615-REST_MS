package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class MsProj10CircuitBreakerHystrixCommanPropertiesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MsProj10CircuitBreakerHystrixCommanPropertiesApplication.class, args);
	}

}
