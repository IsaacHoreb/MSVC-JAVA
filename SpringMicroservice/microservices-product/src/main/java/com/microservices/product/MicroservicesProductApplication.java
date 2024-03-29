package com.microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicesProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesProductApplication.class, args);
    }

}
