package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsProj12ShopingServiceMsAPIGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj12ShopingServiceMsAPIGatewayApplication.class, args);
	}

}
