package com.group2.petcareinfotype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PetCareInfotypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetCareInfotypeApplication.class, args);
    }

}
