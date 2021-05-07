package com.demo.springsecurityexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.GenericDeclaration;

@SpringBootApplication
public class SpringSecurityExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityExampleApplication.class, args);
        //Please enable this code when you want to created an encrypted password for storing in db
       /* BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        System.out.println("-----------------------------------------------");
        System.out.println(encoder.encode("password"));
        System.out.println(encoder.encode("12345678"));
        System.out.println("-----------------------------------------------");*/
    }

}
