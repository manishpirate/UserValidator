package com.example.cloudkafka;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.MessageDigest;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class Sender {

    BlockingDeque<Message<String>> blockingDeque = new LinkedBlockingDeque<Message<String>>();

    public void createMessage(String message, String key){
        Message<String> respToSend = MessageBuilder.withPayload(message).
                setHeader(KafkaHeaders.MESSAGE_KEY, key).
                build();
        blockingDeque.offer(respToSend);
        System.out.println("Message sent from the producer");
    }

    @Bean
    public Supplier<Message<String>> sendMessageDto(){
        return () -> {
           return blockingDeque.poll();
        };
    }

}
