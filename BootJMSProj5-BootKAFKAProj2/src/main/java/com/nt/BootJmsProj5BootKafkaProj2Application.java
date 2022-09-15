package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootJmsProj5BootKafkaProj2Application {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj5BootKafkaProj2Application.class, args);
	}

}
