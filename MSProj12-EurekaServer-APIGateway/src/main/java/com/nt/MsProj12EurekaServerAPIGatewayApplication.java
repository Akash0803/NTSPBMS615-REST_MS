package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsProj12EurekaServerAPIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12EurekaServerAPIGatewayApplication.class, args);
	}

}
