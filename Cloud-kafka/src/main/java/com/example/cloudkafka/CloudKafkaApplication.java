package com.example.cloudkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CloudKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudKafkaApplication.class, args);
    }

}
