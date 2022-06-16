package com.group2.petcarediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PetCareDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareDiscoveryApplication.class, args);
    }

}
