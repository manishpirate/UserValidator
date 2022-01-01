package com.example.cloudkafka;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
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
