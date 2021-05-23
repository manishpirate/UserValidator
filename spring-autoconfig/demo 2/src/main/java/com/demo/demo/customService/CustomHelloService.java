package com.demo.demo.customService;

import com.auto.autoconfig.configService.HelloService;
import org.springframework.context.annotation.Bean;

public class CustomHelloService implements HelloService {

    @Override
    public String getHelloMessage() {
        System.out.println("This is the custom service class");
        return "This is the custom service class";
    }
}
