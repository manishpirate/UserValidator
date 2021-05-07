package com.demo.guestservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
        info = @Info (
              title = "Guest service APIs",
              description ="API definitions of the guest service",
              version = "v 1.0"
        )
)
public class GuestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestServiceApplication.class, args);
    }

}
