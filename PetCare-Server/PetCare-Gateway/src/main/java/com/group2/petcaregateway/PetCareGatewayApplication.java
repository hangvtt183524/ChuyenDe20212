package com.group2.petcaregateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetCareGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareGatewayApplication.class, args);
    }

}
