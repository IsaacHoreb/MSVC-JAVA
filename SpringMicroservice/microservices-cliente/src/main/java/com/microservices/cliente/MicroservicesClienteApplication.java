package com.microservices.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesClienteApplication.class, args);
	}

}
