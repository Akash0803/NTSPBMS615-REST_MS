package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsProj14MiniProjectEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj14MiniProjectEurekaServerApplication.class, args);
	}

}
