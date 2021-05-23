package com.auto.autoconfig.defaultService;

import com.auto.autoconfig.configService.HelloService;

public class DefaultService implements HelloService {

    @Override
    public String getHelloMessage() {
        System.out.println("This is default service");
        return "This is a default service";
    }
}
