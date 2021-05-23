package com.auto.autoconfig.defaultService;

import com.auto.autoconfig.configService.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
public class ConfigClass {

    @Bean
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService getHelloService(){
        return new DefaultService();
    }
}
