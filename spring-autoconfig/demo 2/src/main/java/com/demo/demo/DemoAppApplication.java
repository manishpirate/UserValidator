package com.demo.demo;

import com.auto.autoconfig.configService.HelloService;
import com.demo.demo.customService.CustomHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAppApplication implements CommandLineRunner {

	@Autowired
	HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloService.getHelloMessage();
	}

	@Bean
	public HelloService helloService(){
		return new CustomHelloService();
	}
}
