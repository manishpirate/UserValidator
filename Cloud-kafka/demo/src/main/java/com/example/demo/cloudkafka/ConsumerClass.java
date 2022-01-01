package com.example.demo.cloudkafka;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ConsumerClass {

    @Bean
    public Consumer<Message<String>> getMessageDto(){
        return message -> {
            System.out.println(message.getPayload());
            System.out.println(message.getHeaders());
            //System.out.println("e1.toString() = " + e1.toString());
            System.out.println("printing the topic name" + message.getHeaders().get(KafkaHeaders.PARTITION_ID));
        };
    }
}
